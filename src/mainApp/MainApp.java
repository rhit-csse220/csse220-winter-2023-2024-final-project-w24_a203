package mainApp;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Class: MainApp
 * @author w24_a203
 * <br>Purpose: Top level class for CSSE220 Project containing main method 
 * <br>Restrictions: None
 */
public class MainApp {
	
	public static final Dimension FRAME_SIZE = new Dimension(1500, 800);
	
	private void runApp() {
		System.out.println("Write your cool arcade game here!");	
		
		JFrame myFrame = new JFrame();
		myFrame.setSize(FRAME_SIZE);
		myFrame.setTitle("JETPACK JOYRIDE!");

		
		
		
		
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		myFrame.pack();
		myFrame.setVisible(true);
		
	} // runApp

	
	
	
	/**
	 * ensures: runs the application
	 * @param args unused
	 */
	public static void main(String[] args) {
		MainApp mainApp = new MainApp();
		mainApp.runApp();
	} // main

}