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
	
//	Hero hero = new Hero(200, 500);
	
	private ArrayList<GameObject> listOfObjects;
private Hero hero;

	public MainComponent(ArrayList<GameObject> listOfObjects, Hero hero) {
		System.out.println("In MainComponent File");
		this.listOfObjects = listOfObjects;
		this.hero = hero;
		HeroListener heroListener = new HeroListener(hero);
		this.addKeyListener(heroListener);
		
		
//		for (GameObject object: listOfObjects) { // for tracker missiles
//			if (object.getType() == 'T') {
//				object = new TrackerMissile(object.getX(), object.getY(), Color.magenta, 'T', hero);
//			}
//		}
		
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

	//TODO: Add java doc
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
	
}
