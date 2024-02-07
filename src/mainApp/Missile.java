package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;

/*
 * TODO: ADD JAVA DOCS
 * Class: Missile
 * Purpose: A regular missile that the hero needs to avoid.
 * If the hero is hit, they lose a life.
 */
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
	@Override
	void collidedWithHero() {
		// TODO Auto-generated method stub
		
	}
}
