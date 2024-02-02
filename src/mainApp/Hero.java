package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * TODO: ADD JAVA DOC HERE
 */
public class Hero extends GameObject {
	private int velocity, x, y;
	private static KeyListener KEYBOARD;
	private Color color;
	private static int LINEAR_MOVEMENT;
	private boolean fly;

	public Hero(int x, int y, Color color, Character type) {
		// TODO Auto-generated constructor stub
		super(x, y, color, type);
		this.velocity = 0;
		this.x = x;
		this.color = color;
		this.y = y;
		this.fly = false;
	}

	public void move() {
		if(super.getY() > MainApp.SCREEN_HEIGHT -80 && velocity > 0) {
			velocity = 0;
		}
		y += velocity;
		super.setY(y);
	}

	public void fly() {
		System.out.println(super.getY());
		if (super.getY() > 0) {
			velocity = -10;
			System.out.println("Fly");
		} else {
			velocity = 0;
		}
	}

	public void stopFlying() {
		if (super.getY() > MainApp.SCREEN_HEIGHT -80) {
			velocity = 0;
		}else {
			velocity = 10;
		}
		System.out.println(velocity);
	}

	public int getVelocity() {
		return velocity;
	}

	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}

}
