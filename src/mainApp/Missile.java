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
	private boolean collidedWithHero = false;
	
	public Missile(int x, int y) {
		super(x, y);
	}
	@Override
	public void move() {
		super.setX(getX() - 15);
	}
	
	@Override
	public Graphics2D drawOn(Graphics2D g) {
		g = (Graphics2D)g.create();
		g.setColor(Color.red);
		g.fillRect(super.getX(), super.getY(), 35, 35);
		return g;
	}
	
	@Override
	public boolean collidedWithHero(Hero hero) {
		if(super.collidedWithHero(hero)) {
			System.out.println("Collided with missle");
			collidedWithHero = true;
			return true;
		}else {
			return false;
		}
	}
	
	public boolean ifCollidedWithHero() {
		return collidedWithHero;
	}
}
