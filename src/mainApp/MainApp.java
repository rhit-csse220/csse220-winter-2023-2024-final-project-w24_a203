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
	public static final int SCREEN_WIDTH = 1000;// TODO change to 1500
	public static final int ROWS = 4;
	public static final Dimension FRAME_SIZE = new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT);
	
	private ArrayList<GameObject> listOfObjects;
	private JFrame frame;
	String filename;
	MainComponent mainComponent;
	// private Timer timer;

	private void runApp() throws IOException, ObstacleNotFoundException {
		frame = new JFrame();
		frame.setSize(FRAME_SIZE);
		frame.setTitle("JETPACK JOYRIDE!");

//		listOfObjects = new ArrayList<GameObject>();

		Scanner s = new Scanner(System.in); // DONE: need to close scanner
		filename = null;
		System.out.println("What file should I load?  (e.g. level1.txt)");
		filename = s.nextLine();
		
		// TODO: figure out how to get level name to show up on JFrame as text, NOT TITLE

		mainComponent = new MainComponent(readFile(filename));
		mainComponent.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				System.out.println("Focus lost");
			}

			@Override
			public void focusGained(FocusEvent e) {
				System.out.println("Focus gained");
			}
		});
		mainComponent.requestFocusInWindow();
		mainComponent.addKeyListener(new LevelListener(mainComponent, filename, this));
		frame.add(mainComponent);

		Timer timer = new Timer(DELAY, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainComponent.repaint();
				mainComponent.move();
				frame.repaint();
			}
		});
		timer.start();
		s.close();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.pack();
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
						listOfObjects.add(new GameObject(xVal, yVal, Color.orange, 'C'));
					} else if (line.charAt(i) == 'B') {
						listOfObjects.add(new GameObject(xVal, yVal, Color.pink, 'B'));
					} else if (line.charAt(i) == 'E') {
						listOfObjects.add(new GameObject(xVal, yVal, Color.green, 'E'));
					} else if (line.charAt(i) == 'M') {
						listOfObjects.add(new GameObject(xVal , yVal, Color.red, 'M'));
					} else if (line.charAt(i) == '.') {

					} else {
						throw new ObstacleNotFoundException(line.charAt(i));
					}
				}
				row += 1;

			}
			scanner.close();
//			System.out.println(filename + " was read");
//			MainComponent mainComponent = new MainComponent(listOfObjects);
//			mainComponent.addFocusListener(new FocusListener() {
//				
//				@Override
//				public void focusLost(FocusEvent e) {
//					System.out.println("Focus lost");
//				}
//				
//				@Override
//				public void focusGained(FocusEvent e) {
//					System.out.println("Focus gained");
//				}
//			});
//			Timer timer = new Timer(DELAY, new ActionListener() {
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					System.out.println(filename);
//					mainComponent.repaint();
//					mainComponent.move();
//					frame.repaint();
//				}
//			});
//			mainComponent.requestFocusInWindow();
//			mainComponent.addKeyListener(new LevelListener(this, mainComponent));
//			frame.add(mainComponent);
//			timer.start();
//
//			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////			frame.pack();
//			frame.setVisible(true);
			return listOfObjects;

		} catch (FileNotFoundException e) {
			System.err.println(filename + " WAS NOT FOUND...");
			throw new IOException();
		}
	}

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

	public static int getHeight() { // TODO: we can't use static methods
		return SCREEN_HEIGHT;
	}

//	public void changeLevel(ArrayList<GameObject> objects) {
//		// mainComponent = new MainComponent(objects);
//		filename = "level2.txt";
//		level = 2;
//	}

}

class LevelListener implements KeyListener {
	int level;
	MainApp app;
	String filename;
	MainComponent component;

	// MainComponent mainComponent;
	public LevelListener(MainComponent component, String filename, MainApp app) {
//		this.level = level;
		this.filename = filename;
		this.component = component;
		this.app = app;
		// this.mainComponent = mainComponent;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("Key was pressed");
		if (e.getKeyChar() == 'u') {
			// this.mainComponent = null;
			filename = "level2.txt";
			System.out.println("U pressed");
			System.out.println("in level 2");
			try {
				//app.changeLevel(app.readFile(filename));
				component.changeLevel(app.readFile(filename));

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

		} else if (e.getKeyChar() == 'd') {
			filename = "level1.txt";
			System.out.println("D pressed");
			System.out.println("in level 1");
			try {
				//app.changeLevel(app.readFile(filename));
				component.changeLevel(app.readFile(filename));

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
		} else if (e.getKeyChar() == ' ') { // hero moves
			// TODO: make hero move here
//			hero.move();
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		// System.out.println("test keyrepsea");
	}

}