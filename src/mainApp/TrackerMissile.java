package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

/*
 * Class: TrackerMissile
 * Purpose: A tracking missile that the hero needs to avoid.
 * If the hero is hit, they lose a life. This missile tracks the hero's 
 * movement on screen and add a challenge for the player.
 */
public class TrackerMissile extends Missile {

	private GameObject follow;
	private BufferedImage image;

	public TrackerMissile(int x, int y, Hero hero, JFrame frame) {
		super(x, y, frame);
		this.follow = hero; // hero
		try {
			image = ImageIO.read(new File("sprites/trackerMissile.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void move() {
		int heroY = follow.getY();
		if (heroY < this.getY()) {
			this.setY(this.getY() - 5);
		} else {
			this.setY(this.getY() + 5);
		}
		this.setX(getX() - 15);
	}

	@Override
	public Graphics2D drawOn(Graphics2D g) {
		g = (Graphics2D) g.create();
		g.setColor(Color.MAGENTA);
		g.drawImage(this.image, super.getX(), super.getY(), 75, 35, super.getFrame());
		return g;
	}
}
