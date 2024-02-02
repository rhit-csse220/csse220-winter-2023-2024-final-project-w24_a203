package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

/**
 * TODO: ADD JAVA DOC HERE
 */

//TODO Create the missile, barrier and coin classes
public class GameObject {
	
	private int x, y;
	double angle;
	private Color color;
	private Character type;
	Random rand = new Random();

	public GameObject(int x, int y, Color color, Character type) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		this.color = color;
		this.type = type;
		if(type == 'E' || type == 'B') {
			this.angle = rand.nextDouble(-3.14/2, 3.14/2);
		}
		
	}
	
	//TODO change type inheritance
	public void drawOn(Graphics2D g) {
		g = (Graphics2D)g.create();
		g.setColor(this.color);
		if(type == 'C') {
			g.fillOval(x, y, 40, 40);
		}else if(type == 'H') {
			g.fillRect(x, y, 30, 30);
			this.setY(y);
		} else if (type == 'M') {
			g.fillRect(x, y, 35, 35);
		}else if(type == 'B') {
			g.rotate(angle, x, y);
			g.fillRect(x, y, 20, 200);
		}else if(type == 'E') {
			g.rotate(angle, x, y);
			g.fillRect(x, y, 20, 200);
		}
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void move() { // move screen
		this.x -= 15;
	}
	public int getY() {
		return this.y;
	}
	
	public int getX() {
		return this.x;
	}
	
	

}
