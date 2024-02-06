package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * DONE: ADD JAVA DOCS
 * Class: Barrier
 * Purpose: Non-electric barriers. Hero can bounce off of them - has
 * no impact on hero health. Has different rotations to be an obstacle
 * for the hero 
 */
public class Barrier extends GameObject{

	private int angle;
	
	/** TODO:
	 * ensures: that the barriers show up on screen and at random angles
	 * @param x for x position
	 * @param y for y position
	 */
	public Barrier(int x, int y) {
		super(x,y);
		this.angle = (int) rand.nextDouble(-3.14/2, 3.14/2);
	}
	
	@Override
	public Graphics2D drawOn(Graphics2D g) {
		g = (Graphics2D)g.create();
		g.setColor(Color.pink);
		g.rotate(angle, super.getX(), super.getY());
		g.fillRect(super.getX(), super.getY(), 20, 200);
		return g;
	}
}
