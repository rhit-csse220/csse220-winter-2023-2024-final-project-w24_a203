package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * TODO: ADD JAVA DOC HERE
 */
public class Hero extends GameObject{
	private int velocity,x,y;
	private static  KeyListener KEYBOARD;
	private Color color;
	private static int LINEAR_MOVEMENT;
	private boolean fly;

	public Hero(int x, int y, Color color, Character type) {
		// TODO Auto-generated constructor stub
		super(x,y,color,type);
		this.velocity = 0;
		this.x =x;
		this.color = color;
		this.y = y;
		this.fly = false;
	}
	

	public void move() {
		// TODO Auto-generated method stub
		if(this.y + 55 < MainApp.getHeight() && !this.fly) {
			velocity += 5;
		}
		else if (this.fly) {
			velocity += -5;
//			y--;
//			y = MainApp.getHeight()-55;
		} 
		 
//		if (this.fly == true) {
//			x += 20;
//			
//		}
		else {
			velocity = 0;
			y = MainApp.getHeight()-55;
		}
//		x += LINEAR_MOVEMENT;
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


//	public void setX(int x) {
//		this.x = x;
//	}


//	public int getY() {
//		return y;
//	}


//	public void setY(int y) {
//		this.y = y;
//	}
	
//	public void drawOn(Graphics2D g2) {
//		g2.setColor(this.color);
//		g2.fillRect(x, y, 30, 30);
//	}


	public void flySet(boolean fly) {
		// TODO Auto-generated method stub
		this.fly = fly;
	}
	
	
	
}

 


