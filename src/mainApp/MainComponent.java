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
	
	Hero hero = new Hero(600, 500, Color.BLACK, "Hero");
	private ArrayList<GameObject> listOfObjects;

	public MainComponent(ArrayList<GameObject> listOfObjects) {
		System.out.println("In MainComponent File");
		this.listOfObjects = listOfObjects;
			
		
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		for(GameObject object : listOfObjects) {
			object.drawOn(g2);
		}
		hero.drawOn(g2);
		
		super.paintComponent(g);
		
	}

	public void move() {
		hero.move();
		for(GameObject object : listOfObjects) {
			object.move();
		}
	}
	
}
