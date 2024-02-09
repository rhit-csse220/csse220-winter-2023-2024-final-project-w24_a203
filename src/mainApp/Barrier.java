package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Class: Barrier Purpose: Non-electric barriers. Hero can bounce off of them -
 * has no impact on hero health. Has different rotations to be an obstacle for
 * the hero
 */
public class Barrier extends GameObject {

	private int angle;

	public Barrier(int x, int y) {
		super(x, y);
		this.angle = (int) rand.nextDouble(-3.14 / 2, 3.14 / 2);
	}

	@Override
	public Graphics2D drawOn(Graphics2D g) {
		g = (Graphics2D) g.create();
		g.setColor(Color.pink);
		g.rotate(angle, super.getX(), super.getY());
		g.fillRect(super.getX(), super.getY(), 20, 200);
		return g;
	}

	@Override
	public boolean collidedWithHero(Hero hero) {
		if (Math.abs(hero.getX() - this.getX()) < 20 && Math.abs(hero.getY() - this.getY()) < 200) {
			System.out.println("Colided with barrier");
			return true;
		} else {
			return false;
		}
	}
}
