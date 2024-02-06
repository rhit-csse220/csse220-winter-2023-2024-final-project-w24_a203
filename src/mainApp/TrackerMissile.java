package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * TODO: Add java doc
 * want to track the hero's movement for sometime
 */
public class TrackerMissile extends Missile {

	private GameObject follow;

	public TrackerMissile(int x, int y, Hero hero) {
		super(x, y);
		this.follow = hero; // hero

	}
	
	@Override
	public void move() {
		// TODO Auto-generated method stub
//		super.move();
//		System.out.println(follow.getY());
		int heroY = follow.getY();
			this.setY(follow.getY());
			this.setX(getX() - 15);
		
	}
	
	@Override
	public Graphics2D drawOn(Graphics2D g) {
		// TODO Auto-generated method stub
		g = (Graphics2D)g.create();
		g.setColor(Color.MAGENTA);
		g.fillRect(super.getX(), super.getY(), 35, 35);
		return g;
	}
}
