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
	

	public void move() {
		// TODO Auto-generated method stub
		if(this.y + 55 < MainApp.getHeight()) {
			velocity += 5;
		}
		else {
			velocity = 0;
			y = MainApp.getHeight()-55;
		}
		y += velocity;
		super.setY(y);
	}
	
}
