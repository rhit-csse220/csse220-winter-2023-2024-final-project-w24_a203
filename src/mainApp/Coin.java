package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;

public class Coin extends GameObject {

	/**
	 * DONE: ADD JAVA DOCS Class: Coin Purpose: Coins that hero can collect. Hero
	 * gets points for each coin collected. After a coin is collected, it disappears
	 * from screen.
	 */

	public Coin(int x, int y) {
		super(x, y);
	}

	@Override
	public Graphics2D drawOn(Graphics2D g) {
		g = (Graphics2D) g.create();
		g.setColor(Color.orange);
		g.fillOval(super.getX(), super.getY(), 40, 40);
		return g;
	}

	@Override
	public boolean collidedWithHero(Hero hero) {
		if(super.collidedWithHero(hero)) {
			//System.out.println("Collided with coin");
			setX(-10); //removes the coin from JFrame
			return true;
		}else {
			return false;
		}
	}

	public void removeCoin() {

	}

}
