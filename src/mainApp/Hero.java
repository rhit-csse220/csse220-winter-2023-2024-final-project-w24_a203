package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * TODO: ADD JAVA DOC HERE
 */
public class Hero extends GameObject {
	private int velocity;
	private boolean fly;
	
	public Hero(int x, int y, Color color, Character type) {
		super(x, y, color, type);
		this.velocity = 0;
		this.fly = false;
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
}
