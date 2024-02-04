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
	
	public Hero(int x, int y, Color color, Character type) {
		super(x, y, color, type);
		this.velocity = 0;
	}
	
	public void move() {
		if(super.getY() > MainApp.SCREEN_HEIGHT -80 && velocity > 0) {
			velocity = 0;
		}
		super.setY(getY() + velocity);
	}

	public void fly() {
		System.out.println(super.getY());
		if (super.getY() > 0) {
			velocity = -10;
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
	}
}
