package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

/**
 * TODO: ADD JAVA DOC HERE
 * Class: Hero
 * Purpose: Hero that the player controls. Can interact
 * with each game object - some causes the hero to die (missiles 
 * & electric barriers), others give the hero points (coins),
 * others do nothing (regular barriers.
 */
public class Hero extends GameObject {
	private int velocity;
	private boolean fly;
	private boolean push;
	
	public Hero(int x, int y) {
		super(x, y);
		this.velocity = 0;
		this.fly = false;
		this.push= false;
	}
	public void move() {
		if(fly) {
			velocity = -10;
		}
		else {
			velocity += 1;
		}
		if(super.getY() > MainApp.SCREEN_HEIGHT - 70 && velocity > 0) {
			velocity = 0;
			super.setY(MainApp.SCREEN_HEIGHT - 70);
		}
		if(super.getY() < 0 && velocity < 0) {
			velocity = 0;
			super.setY(0);
		}
		if(super.getX()<200) {
			super.setX(super.getX()+1);
		}
		super.setY(getY() + velocity);
	}

	public void fly() {
//		System.out.println(super.getY());
//		if (super.getY() > 0) {
//			velocity = -10;
//		} else {
//			velocity = 0;
//		}
		this.fly = true;
	}

	public void stopFlying() {
//		if (super.getY() > MainApp.SCREEN_HEIGHT -80) {
//			velocity = 0;
//		}else {
//			velocity = 10;
//		}
		this.fly = false;
	}
	
	
	@Override
	public Graphics2D drawOn(Graphics2D g) {
		g = (Graphics2D)g.create();
		g.setColor(Color.black);
		g.fillRect(super.getX(), super.getY(), 30, 30);
		return g;
	}
	public Rectangle2D.Double getBoundingBox() {
		return new Rectangle2D.Double(super.getX(), super.getY(), 30, 30 );
	}
	public void pushBack() {
		// TODO Auto-generated method stub
		super.setX(super.getX()-6);
	}
}
