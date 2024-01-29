package mainApp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

/**
 * TODO: ADD JAVA DOC HERE
 */
public class MainComponent extends JComponent{
	
	GameObject testCoin = new GameObject(500,500,Color.ORANGE, "TEST");

	public MainComponent() {
		// TODO Auto-generated constructor stub
		System.out.println("In MainComponent File");
		
		
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		
		testCoin.drawOn(g2);
		
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
	}

}
