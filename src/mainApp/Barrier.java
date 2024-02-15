package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Class: Barrier 
 * Purpose: Non-electric barriers. Hero can bounce off of them -
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
			e.printStackTrace();
		}
	}

	@Override
	public Graphics2D drawOn(Graphics2D g) {
		g = (Graphics2D) g.create();
		g.setColor(Color.pink);
		g.rotate(angle, super.getX(), super.getY());
		g.drawImage(image, super.getX(), super.getY(), 20, 200, super.getFrame());
		return g;
	}

	@Override
	public boolean collidedWithHero(Hero hero) {
		return getBoundingBox().intersects(hero.getBoundingBox());
	}

	public Line2D.Double getBoundingBox() {
		return new Line2D.Double(super.getX(), super.getY(), Math.sin(-angle) * 200 + super.getX(), Math.cos(-angle) * 200 + super.getY());
	}
}
