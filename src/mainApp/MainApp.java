package mainApp;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Class: MainApp AKA MainViewer
 * @author w24_a203
 * <br>Purpose: Top level class for CSSE220 Project containing main method 
 * <br>Restrictions: None
 * 
 */
public class MainApp {
	
	public static final Dimension FRAME_SIZE = new Dimension(1500, 800);
	public static final int DELAY = 50;
	public static final int SCREEN_HEIGHT = 800;
	
	private void runApp() throws IOException, ObstacleNotFoundException {
//		System.out.println("Write your cool arcade game here!");	
		
		JFrame frame = new JFrame();
		frame.setSize(FRAME_SIZE);
		frame.setTitle("JETPACK JOYRIDE!");
		
		Scanner s = new Scanner(System.in);
		String filename = null;
		System.out.println("What file should I load?  (e.g. level1.txt)");
		filename = s.nextLine();
		readFile(filename);
		
		MainComponent mainComponent = new MainComponent();
		frame.add(mainComponent);
		


		Timer timer = new Timer(DELAY, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				mainComponent.update(null);
				mainComponent.repaint();
				mainComponent.move();
				frame.repaint();
			}
		});
		timer.start();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.pack();
		frame.setVisible(true);
		
	} // runApp

	
	private void readFile(String filename) throws FileNotFoundException, IOException, ObstacleNotFoundException {
		
//		Scanner s = new Scanner(System.in);
////		filename = "level1.txt";
//		filename = s.nextLine();
//		
//		
//		System.out.println("App terminated");
//		s.close();	
		
		File file = new File(filename);
		
		try {
			
			Scanner scanner = new Scanner(file);
			
			while (scanner.hasNext()) {
				String line = scanner.nextLine();
//				System.out.println(line);
				
				for (int i = 0; i < line.length(); i++) {
					if (line.charAt(i) == 'C') {
						System.out.println("Create Coin!");
					} else if (line.charAt(i) == 'B') {
						System.out.println("Create Regular Barrier!");
					} else if (line.charAt(i) == 'E') {
						System.out.println("Create Electric Barrier!");
					} else if (line.charAt(i) == 'M') {
						System.out.println("Create Missile!");
					} else if (line.charAt(i) == '.') {
						System.out.println("KEEP GOING!");
					} else {
						throw new ObstacleNotFoundException(line.charAt(i));
					}
				}
			}
			scanner.close();
			System.out.println(filename + " was read");
			
		} catch (FileNotFoundException e) {
			System.err.println(filename + " WAS NOT FOUND...");
			throw new IOException();
//			e.printStackTrace();
		}
	}
	
	/**
	 * ensures: runs the application
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
	
	public static int getHeight() {
		return SCREEN_HEIGHT;
	}
}