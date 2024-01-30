package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * TODO: ADD JAVA DOC HERE
 */
public class GameObject {
	
	private int x, y;
	private Color color;
	private String type;

	public GameObject(int x, int y, Color color, String type) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		this.color = color;
		this.type = type;
		
	}
	
	public void drawOn(Graphics2D g) {
		g = (Graphics2D)g.create();
		g.setColor(this.color);
		g.fillRect(x, y, 20, 20);
	}
	
	public void move() {
		if(type.equals("hero")) {
			this.move();
		}
	}

	public void setY(int y) {
		// TODO Auto-generated method stub
		this.y = y;
	}
}
