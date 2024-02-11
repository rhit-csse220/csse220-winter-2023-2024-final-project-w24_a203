package mainApp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

/**
 * Class: MainApp AKA MainViewer
 * 
 * @author w24_a203 <br>
 *         Purpose: Top level class for CSSE220 Project containing main method
 *         <br>
 *         Restrictions: None
 * 
 */
public class MainApp {

	public static final int DELAY = 50;
	public static final int SCREEN_HEIGHT = 800;
	public static final int SCREEN_WIDTH = 1000;
	public static final int ROWS = 4;
	public static final Dimension FRAME_SIZE = new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT);
	Hero hero = new Hero(250, 500);
	
	private ArrayList<GameObject> listOfObjects;
	//TODO add classes
	//TODO check if the design does not violate 5 principles 
	private void runApp() throws IOException, ObstacleNotFoundException {
		JFrame frame = new JFrame();
		frame.setSize(FRAME_SIZE);
		frame.setTitle("JETPACK JOYRIDE!");

		Scanner s = new Scanner(System.in); 
		System.out.println("What file should I load?  (e.g. level1.txt)");
		String filename = s.nextLine();

		MainComponent mainComponent = new MainComponent(readFile(filename),hero);
		mainComponent.requestFocusInWindow();
		mainComponent.addKeyListener(new LevelListener(mainComponent, filename, this));
		frame.add(mainComponent);

		Timer timer = new Timer(DELAY, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainComponent.repaint();
				mainComponent.move();
				if(mainComponent.collideWithMissile()) {
					try {
						mainComponent.changeLevel(readFile(filename));
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ObstacleNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				//mainComponent.print(null);
				frame.repaint();
			}
		});
		timer.start();
		s.close();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	} // runApp

	public ArrayList<GameObject> readFile(String filename)
			throws FileNotFoundException, IOException, ObstacleNotFoundException {

		File file = new File(filename);

		try {

			Scanner scanner = new Scanner(file);
			int row = 0;
			listOfObjects = new ArrayList<GameObject>();
			while (scanner.hasNext()) {
				String line = scanner.nextLine();

				for (int i = 0; i < line.length(); i++) {

					int xVal = i * (SCREEN_WIDTH / 10);
					int yVal = row * (SCREEN_HEIGHT / ROWS) + 30;

					if (line.charAt(i) == 'C') {
						Coin coin = new Coin(xVal, yVal);
						listOfObjects.add(coin);
					} else if (line.charAt(i) == 'B') {
						listOfObjects.add(new Barrier(xVal, yVal));
					} else if (line.charAt(i) == 'E') {
						listOfObjects.add(new ElectricBarrier(xVal, yVal));
					} else if (line.charAt(i) == 'M') {
						listOfObjects.add(new Missile(xVal , yVal));
					} 
					else if (line.charAt(i) == 'T') {
						listOfObjects.add(new TrackerMissile(xVal , yVal, hero));
					} else if (line.charAt(i) == '.') {

					} else {
						throw new ObstacleNotFoundException(line.charAt(i));
					}
				}
				row += 1;

			}
			scanner.close();
			return listOfObjects;

		} catch (FileNotFoundException e) {
			System.err.println(filename + " WAS NOT FOUND...");
			throw new IOException();
		}
	} // readFile

	/**
	 * ensures: runs the application
	 * 
	 * @param args unused
	 */
	public static void main(String[] args) throws IOException, ObstacleNotFoundException {
		MainApp mainApp = new MainApp();

		while (true) {
			try {
				mainApp.runApp();
				break;
			} catch (ObstacleNotFoundException e) {

				System.err.println("File is incorrect. Try again.." + e.getMessage());

			} catch (IOException e) {
				System.err.println("File not found. Try again..");

			}
		}

	} // main

}
