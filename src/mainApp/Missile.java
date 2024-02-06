package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;

public class Missile extends GameObject{

	public Missile(int x, int y) {
		super(x, y);
	}
	@Override
	public void move() {
		super.setX(getX() - 15);
//		super.setY(getY() + 4);
	}
	
	@Override
	public Graphics2D drawOn(Graphics2D g) {
		// TODO Auto-generated method stub
		g = (Graphics2D)g.create();
		g.setColor(Color.red);
		g.fillRect(super.getX(), super.getY(), 35, 35);
		return g;
	}
}
