package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

/**
 * TODO: ADD JAVA DOC HERE
 */

//TODO Create the barrier and coin classes
public class GameObject {
	
	private int x, y;
	double angle;
	private Color color;
	private Character type;
	Random rand = new Random();

	public GameObject(int x, int y, Color color, Character type) {
		this.x = x;
		this.y = y;
		this.color = color;
		this.type = type;
		if(type == 'E' || type == 'B') {
			this.angle = rand.nextDouble(-3.14/2, 3.14/2);
		}
		
	}
	
	//TODO change type inheritance
	public Graphics2D drawOn(Graphics2D g) {
		g = (Graphics2D)g.create();
		g.setColor(this.color);
		if(type == 'C') {
			g.fillOval(x, y, 40, 40);
		}else if(type == 'H') {
			g.fillRect(x, y, 30, 30);
			this.setY(y);
		}else if (type == 'M') {
			g.fillRect(x, y, 35, 35);
		}else if (type == 'T'){
			g.fillRect(x, y, 35, 35);
		}else if(type == 'B') {
			g.rotate(angle, x, y);
			g.fillRect(x, y, 20, 200);
		}else if(type == 'E') {
			g.rotate(angle, x, y);
			g.fillRect(x, y, 20, 200);
		}
		return g;
	}
	
	public Character getType () {
		return type;
		
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void move() { // move screen
		this.x -= 5;
	}
	public int getY() {
		return this.y;
	}
	
	public int getX() {
		return this.x;
	}
	
	

}
