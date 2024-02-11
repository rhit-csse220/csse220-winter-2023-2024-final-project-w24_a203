package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;

/*
 * TODO: ADD JAVA DOCS
 * Class: TrackerMissile
 * Purpose: A tracking missile that the hero needs to avoid.
 * If the hero is hit, they lose a life. This missile tracks the hero's 
 * movement on screen and add a challenge for the player.
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
		if(heroY < this.getY()) {
			this.setY(this.getY()-5);
		}
		else {
			this.setY(this.getY()+5);
		}

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
