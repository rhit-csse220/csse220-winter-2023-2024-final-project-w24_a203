package mainApp;

import java.awt.Color;
import java.awt.event.KeyListener;

/**
 * TODO: ADD JAVA DOC HERE
 */
public class Hero extends GameObject{
	private int velocity,x,y;
	private HeroListener keyboard;

	public Hero(int x, int y, Color color, Character type) {
		// TODO Auto-generated constructor stub
		super(x,y,color,type);
		this.velocity = 0;
		this.y = y;
		this.keyboard = keyboard; 
	}
	

	public void move(boolean isKeyPressed) {
		// TODO Auto-generated method stub
		if(this.y + 55 < MainApp.getHeight()) {
			velocity += 5;
		}
		else if (isKeyPressed) {
			velocity = 5;
//			y = MainApp.getHeight()-55;
		} else {
			velocity = 0;
			y = MainApp.getHeight()-55;
		}
		y += velocity;
		super.setY(y);
	}


	public int getVelocity() {
		return velocity;
	}


	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}


//	public int getX() {
//		return x;
//	}


	public void setX(int x) {
		this.x = x;
	}


//	public int getY() {
//		return y;
//	}


	public void setY(int y) {
		this.y = y;
	}
	
	
}
