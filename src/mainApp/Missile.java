package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

/*
 * Class: Missile
 * Purpose: A regular missile that the hero needs to avoid.
 * If the hero is hit, they lose a life.
 */
public class Missile extends GameObject {
	private boolean collidedWithHero = false;
	private BufferedImage image;

	public Missile(int x, int y, JFrame frame) {
		super(x, y, frame);
		try {
			image = ImageIO.read(new File("sprites/missile.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void move() {
		super.setX(getX() - 15);
	}

	@Override
	public Graphics2D drawOn(Graphics2D g) {
		g = (Graphics2D) g.create();
		g.setColor(Color.red);
		g.drawImage(this.image, super.getX(), super.getY(), 75, 35, super.getFrame());
		return g;
	}

	@Override
	public boolean collidedWithHero(Hero hero) {
		if (super.collidedWithHero(hero)) {
			collidedWithHero = true;
			return true;
		} else {
			return false;
		}
	}

	public boolean ifCollidedWithHero() {
		return collidedWithHero;
	}
}
