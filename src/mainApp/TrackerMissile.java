package mainApp;

import java.awt.Color;

/**
 * TODO: Add java doc
 * want to track the hero's movement for sometime
 */
public class TrackerMissile extends Missile {

	private GameObject follow;

	public TrackerMissile(int x, int y, Color color, Character type, GameObject follow) {
		super(x, y, color, type);
		this.follow = follow; // hero

	}
	
	@Override
	public void move() {
		// TODO Auto-generated method stub
//		super.move();
			this.setY(follow.getY());
			this.setX(getX() - 10);
		
	}

}
