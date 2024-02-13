package mainApp;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
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

import javax.swing.JButton;
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
//	private Hero hero = new Hero(250, 500);
	private Hero hero;
	private Timer timer;
	private JFrame frame;
	public boolean IfGameIsOver = false;

	private ArrayList<GameObject> listOfObjects;
	private MainComponent mainComponent;

	// TODO add classes
	// TODO check if the design does not violate 5 principles
	private void runApp() throws IOException, ObstacleNotFoundException {
		frame = new JFrame();
		frame.setSize(FRAME_SIZE);
		frame.setTitle("JETPACK JOYRIDE!");

		Scanner s = new Scanner(System.in);
		System.out.println("What file should I load?  (e.g. level1.txt)");
		String filename = s.nextLine();
		hero = new Hero(250, 500, frame);
		mainComponent = new MainComponent(readFile(filename), hero, frame);
		mainComponent.requestFocusInWindow();
		LevelListener levelListner = new LevelListener(mainComponent, filename, this);
		mainComponent.addKeyListener(levelListner);
		frame.add(mainComponent);

		timer = new Timer(DELAY, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainComponent.repaint();
				mainComponent.move();
				String filename1 = levelListner.getFilename();
				if (mainComponent.isLevelCompleted()) {
					if (filename1.equals("level1.txt")) {
						try {
							//String filename = "level2.txt";
							mainComponent.changeLevel(readFile("level2.txt"));
							filename1 = "level2.txt";
							levelListner.setFilename(filename1);
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
					} else if (filename1.equals("level2.txt")) {
		
	// TODO: JBUTTONS TO RESTART/EXIT GAME WHEN PLAYER WINS
						gameOver();
						
					}
				}
				System.out.println(levelListner.getFilename());
				if (mainComponent.collideWithMissile()) {
					try {
						mainComponent.changeLevel(readFile(filename1));
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
				// mainComponent.print(null);
				frame.repaint();
			}
		});
		timer.start();
		s.close();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	} // runApp

	public void gameOver() {
//		timer.stop();
		IfGameIsOver = true;
		mainComponent.setGameOver(true);
//		frame.setBackground(Color.blue);
//		System.out.println("Game Over");
//		frame.removeAll();
//		frame.repaint();
//		JButton button = new JButton("Game Over");
//		frame.add(button);
		frame.repaint();
		
	}
	public boolean getGameOver() {
		return IfGameIsOver;
	}
	
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
						Coin coin = new Coin(xVal, yVal, frame);
						listOfObjects.add(coin);
					} else if (line.charAt(i) == 'B') {
						listOfObjects.add(new Barrier(xVal, yVal));
					} else if (line.charAt(i) == 'E') {
						listOfObjects.add(new ElectricBarrier(xVal, yVal,frame));
					} else if (line.charAt(i) == 'M') {
						listOfObjects.add(new Missile(xVal, yVal, frame));
					} else if (line.charAt(i) == 'T') {
						listOfObjects.add(new TrackerMissile(xVal, yVal, hero, frame));
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

	public void close() {
		// TODO Auto-generated method stub
		frame.dispose();
		System.exit(0);
	}

	public void restart() {
		// TODO Auto-generated method stub
		IfGameIsOver = false;
		mainComponent.setGameOver(false);
		try {
			mainComponent.changeLevel(readFile("level1.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ObstacleNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
