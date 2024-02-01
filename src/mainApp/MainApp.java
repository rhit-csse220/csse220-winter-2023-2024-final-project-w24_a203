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
 * @author w24_a203
 * <br>Purpose: Top level class for CSSE220 Project containing main method 
 * <br>Restrictions: None
 * 
 */
public class MainApp {
	
	public static final int DELAY = 50;
	public static final int SCREEN_HEIGHT = 800;
	public static final int SCREEN_WIDTH = 1500;
	public static final int ROWS = 4;
	public static final Dimension FRAME_SIZE = new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT);
	
	private ArrayList<GameObject> listOfObjects;
	
	private void runApp() throws IOException, ObstacleNotFoundException {		
		JFrame frame = new JFrame();
		frame.setSize(FRAME_SIZE);
		frame.setTitle("JETPACK JOYRIDE!");
		
//		listOfObjects = new ArrayList<GameObject>();
		
		Scanner s = new Scanner(System.in);  //TODO: need to close scanner
		String filename = null;
		System.out.println("What file should I load?  (e.g. level1.txt)");
		filename = s.nextLine();
		
		
		// TODO: figure out how to get level to show up on JFRAME screen when changing levels
		// Comment out/delete this line when finished
		frame.setTitle(filename);
		
		MainComponent mainComponent = readFile(filename);
		mainComponent.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				System.out.println("keytyped");
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				System.out.println("keyr");
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
				System.out.println("keypresfhsdjka");
			}
		});
		
		frame.add(mainComponent);
//		System.out.println("main component added to frame");

		Timer timer = new Timer(DELAY, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
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
	

	
	public MainComponent readFile(String filename) throws FileNotFoundException, IOException, ObstacleNotFoundException {
		
		File file = new File(filename);
		
		try {
			
			Scanner scanner = new Scanner(file);
			int row = 0;
			listOfObjects = new ArrayList<GameObject>();
			while (scanner.hasNext()) {
				String line = scanner.nextLine();				
				
				for (int i = 0; i < line.length(); i++) {
					
					int xVal =  i*(SCREEN_WIDTH/10);
					int yVal = row *(SCREEN_HEIGHT/ROWS) + 30;
					
	
					if (line.charAt(i) == 'C') {
						listOfObjects.add(new GameObject(xVal, yVal, Color.orange, 'C'));
					} else if (line.charAt(i) == 'B') {
						listOfObjects.add(new GameObject(xVal , yVal, Color.pink, 'B'));
					} else if (line.charAt(i) == 'E') {
						listOfObjects.add(new GameObject(xVal , yVal, Color.green, 'E'));
					} else if (line.charAt(i) == 'M') {
//						listOfObjects.add(new GameObject(xVal , yVal, Color.red, 'M'));
					} else if (line.charAt(i) == '.') {
						
					} else {
						throw new ObstacleNotFoundException(line.charAt(i));
					}
				}
				row += 1;
				
			}
			scanner.close();
			System.out.println(filename + " was read");
			MainComponent mainComponent = new MainComponent(listOfObjects);
			return mainComponent;
			
		} catch (FileNotFoundException e) {
			System.err.println(filename + " WAS NOT FOUND...");
			throw new IOException();
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
	
	public static int getHeight() {  //TODO: we can't use static methods
		return SCREEN_HEIGHT;
	}
	

}

class LevelListener implements FocusListener {
	int level;
	MainApp app;
	String filename;
	
	
	public LevelListener(MainApp app) {
//		this.level = level;
		this.app = app;
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("keychar: " + e.getKeyChar());
		if(e.getKeyChar() == 'u'){
			filename = "level2.txt";
			System.out.println("U pressed");
			try {
				System.out.println("keypress try/catch");
				app.readFile(filename);
				
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
		
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("test keyrepsea");
	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}