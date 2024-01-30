package mainApp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

/**
 * TODO: ADD JAVA DOC HERE
 */
public class MainComponent extends JComponent{
	
	GameObject testCoin = new GameObject(500,500,Color.ORANGE, "Test Coin");
	GameObject testBarrier = new GameObject(400, 500, Color.cyan, "Test Barrier");
	
	Hero hero = new Hero(600, 500, Color.BLACK, "Hero");

	public MainComponent() {
		// TODO Auto-generated constructor stub
		System.out.println("In MainComponent File");
		
		
		
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		
		testCoin.drawOn(g2);
		testBarrier.drawOn(g2);
		hero.drawOn(g2);
		
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
	}

	public void move() {
		// TODO Auto-generated method stub
		hero.move();
	}

}
