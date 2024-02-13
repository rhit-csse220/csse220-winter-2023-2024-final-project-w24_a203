package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

//import game.GameObject;

/**
 * Class: Barrier Purpose: Non-electric barriers. Hero can bounce off of them -
 * has no impact on hero health. Has different rotations to be an obstacle for
 * the hero
 */
public class Barrier extends GameObject {

	private int angle;
	private BufferedImage image;

	public Barrier(int x, int y) {
		super(x, y);
		this.angle = (int) rand.nextDouble(-3.14 / 2, 3.14 / 2);
		try {
			image = ImageIO.read(new File("sprites/barrier.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		this.angle = Angle;
		
				
	}

	@Override
	public Graphics2D drawOn(Graphics2D g) {
		g = (Graphics2D) g.create();
		g.setColor(Color.pink);
//		g.drawLine(super.getX(), super.getY(),(int)(Math.sin(-angle)*200+super.getX()),(int)(Math.cos(-angle)*200+super.getY()));
		g.rotate(angle, super.getX(), super.getY());
		g.drawImage(image, super.getX(), super.getY(), 20, 200, super.getFrame());
//		g.fillRect(super.getX(), super.getY(), 20, 200);
		return g;
	}

	@Override
	public boolean collidedWithHero(Hero hero) {
//		if (Math.abs(hero.getX() - this.getX()) < 20 && Math.abs(hero.getY() - this.getY()) < 200) {
//			//System.out.println("Collided with barrier");
//			return true;
//		} else {
//			return false;
//		}

			return getBoundingBox().intersects(hero.getBoundingBox());
		}
	public Line2D.Double getBoundingBox() {
//		return new Rectangle2D.Double(super.getX(), super.getY(), 20, 200 );
		
		return new Line2D.Double(super.getX(), super.getY(),Math.sin(-angle)*200+super.getX(),Math.cos(-angle)*200+super.getY());
	}
}
