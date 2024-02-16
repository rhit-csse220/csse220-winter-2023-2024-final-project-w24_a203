package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.ImageObserver;
import java.util.Random;

import javax.swing.JFrame;

/**
 * Class: GameObject
 * Purpose: Abstract class that keeps track of each game object (coins, barriers, missiles)
 * It also deals with hero collision with each object.
 */
public abstract class GameObject {
	
	private int x, y;
	double angle;
	Random rand = new Random();
	private JFrame frame;

	public GameObject(int x, int y, JFrame frame) {
		this.x = x;
		this.y = y;
		this.frame =frame;
		
	}
	public GameObject(int x, int y) {
		this.x = x;
		this.y = y;
		
	}
	public boolean collidedWithHero(Hero hero) {
		if(Math.abs(this.getX() - hero.getX()) < 30 && Math.abs(this.getY() - hero.getY()) < 30) {
			return true;
		}else {
			return false;
		}
	}
	
	abstract Graphics2D drawOn(Graphics2D g);

	
	public void setY(int y) {
		this.y = y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void move() { // move screen
		this.x -= 10; // TODO change to 5
	}
	public int getY() {
		return this.y;
	}
	
	public int getX() {
		return this.x;
	}
	public ImageObserver getFrame() {
		return frame;
	}
	
	

}
