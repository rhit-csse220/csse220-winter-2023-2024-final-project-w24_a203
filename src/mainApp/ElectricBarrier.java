package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Line2D;

import javax.sound.sampled.Line;


/**
 * Class: ElectricBarrier
 * Purpose: Electric barriers. Hero can not bounce off of them - hero
 * loses a life on each impact. Has different rotations to be an obstacle
 * for the hero 
 */
public class ElectricBarrier extends GameObject{

	private int angle;

	public ElectricBarrier(int x, int y) {
		super(x,y);
		this.angle = (int) rand.nextDouble(-3.14/2, 3.14/2);
	}
	

	@Override
	public Graphics2D drawOn(Graphics2D g) {
		g = (Graphics2D)g.create();
		g.setColor(Color.green);
		g.rotate(angle, super.getX(), super.getY());
		g.fillRect(super.getX(), super.getY(), 20, 200);
		return g;
	}


	@Override
	public boolean collidedWithHero(Hero hero) {
//		if (Math.abs(hero.getX() - this.getX()) < 20 && Math.abs(hero.getY() - this.getY()) < 200) {
//			//System.out.println("Colided with barrier");
//			return true;
//		} else {
//			return false;
//		}
//		Graphics2D g = (Graphics2D)g.create();
//		Line2D line = new Line2D.Double(super.getX(), super.getY(),Math.sin(angle)*200,Math.cos(angle)*200);
//		Area barrier = new Area
		return getBoundingBox().intersects(hero.getBoundingBox());
	}
	public Line2D.Double getBoundingBox() {
//		return new Rectangle2D.Double(super.getX(), super.getY(), 20, 200 );
		return new Line2D.Double(super.getX(), super.getY(),Math.sin(-angle)*200+super.getX(),Math.cos(-angle)*200+super.getY());
	}
}
