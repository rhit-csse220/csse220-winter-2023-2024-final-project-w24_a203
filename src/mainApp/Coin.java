package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;

public class Coin extends GameObject{

	/**
	 * DONE: ADD JAVA DOCS
	 * Class: Coin
	 * Purpose: Coins that hero can collect. Hero gets points for each
	 * coin collected. After a coin is collected, it disappears from screen.
	 */
	
	public Coin(int x, int y) {
		// TODO Auto-generated constructor stub
		super(x,y);
	}
	
	@Override
	public Graphics2D drawOn(Graphics2D g) {
		// TODO Auto-generated method stub
		g = (Graphics2D)g.create();
		g.setColor(Color.orange);
		g.fillOval(super.getX(), super.getY(), 40, 40);
		return g;
	}
	
	@Override
	void collidedWithHero() {
		System.out.println("Collided with teh coin");
		this.removeCoin();
		
	}
	
	public void removeCoin() {
		
	}

}
