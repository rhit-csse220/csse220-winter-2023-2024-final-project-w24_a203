package mainApp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JComponent;

/**
 * TODO: ADD JAVA DOC HERE
 */
public class MainComponent extends JComponent{
//	public static final int OBJECT_PLACEMENT_X = 1400;
//	public static final int OBJECT_PLACEMENT_Y = 700;
	
	GameObject testCoin = new GameObject(500,500,Color.ORANGE, "Test Coin");
	GameObject testBarrier = new GameObject(400, 500, Color.cyan, "Test Barrier");
	
	Hero hero = new Hero(600, 500, Color.BLACK, "Hero");
	private ArrayList<GameObject> listOfObjects;

	public MainComponent(ArrayList<GameObject> listOfObjects) {
		// TODO Auto-generated constructor stub
		System.out.println("In MainComponent File");
		this.listOfObjects = listOfObjects;
		
		
		
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		for(GameObject object : listOfObjects) {
			object.drawOn(g2);
		}
		testCoin.drawOn(g2);
		testBarrier.drawOn(g2);
		hero.drawOn(g2);
		
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
	}

	public void move() {
		// TODO Auto-generated method stub
		hero.move();
		for(GameObject object : listOfObjects) {
			object.move();
		}
	}
	
//	public void addCoin() {
//		listOfObjects.add(new GameObject(OBJECT_PLACEMENT_X, OBJECT_PLACEMENT_Y, Color.orange, "C"));
//	}

}
