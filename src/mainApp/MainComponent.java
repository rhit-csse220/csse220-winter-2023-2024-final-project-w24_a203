package mainApp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import javax.swing.JComponent;

/**
 * TODO: ADD JAVA DOC HERE
 */
public class MainComponent extends JComponent{
	
	Hero hero = new Hero(200, 500, Color.BLACK, 'H');
	HeroListener heroListener = new HeroListener(hero);
	private ArrayList<GameObject> listOfObjects;

	public MainComponent(ArrayList<GameObject> listOfObjects) {
		System.out.println("In MainComponent File");
		this.listOfObjects = listOfObjects;
		this.addKeyListener(heroListener);
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		removeObjects();
		for(GameObject object : listOfObjects) {
			object.drawOn(g2);
		}
		hero.drawOn(g2);

		
		super.paintComponent(g);
	}

	//TODO: Add java docs 
	public void move() {
		hero.move();
		for(GameObject object : listOfObjects) {
			object.move();
		}
	}
	
	//TODO: Add java docs 
	public void removeObjects() {
		ArrayList<GameObject> objectsToRemove = new ArrayList<GameObject>();
		for(GameObject object : listOfObjects) {
			if(object.getX() < 0) {
				objectsToRemove.add(object);
			}
		}
		listOfObjects.removeAll(objectsToRemove);
	}
	
	public void changeLevel(ArrayList<GameObject> objects) {
		listOfObjects = objects;
	}
	
	@Override
	public boolean isFocusable() {
		return true;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "position "+listOfObjects.get(0).getX();
	}
	
}
