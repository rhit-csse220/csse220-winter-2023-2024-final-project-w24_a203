package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;


/**
 * DONE: ADD JAVA DOCS
 * Class: ElectricBarrier
 * Purpose: Electric barriers. Hero can not bounce off of them - hero
 * loses a life on each impact. Has different rotations to be an obstacle
 * for the hero 
 */
public class ElectricBarrier extends GameObject{

	private int angle;
	
	/** TODO:
	 * ensures: 
	 * @param 
	 * <br>requires: 
	 * @param 
	 * <br>requires: 
	 */
	public ElectricBarrier(int x, int y) {
		// TODO Auto-generated constructor stub
		super(x,y);
		this.angle = (int) rand.nextDouble(-3.14/2, 3.14/2);
	}
	
	/** TODO:
	 * 
	 */
	@Override
	public Graphics2D drawOn(Graphics2D g) {
		// TODO Auto-generated method stub
		g = (Graphics2D)g.create();
		g.setColor(Color.green);
		g.rotate(angle, super.getX(), super.getY());
		g.fillRect(super.getX(), super.getY(), 20, 200);
		return g;
	}
}
