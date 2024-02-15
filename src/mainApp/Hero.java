package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 * Class: Hero Purpose: Hero that the player controls. Can interact with each
 * game object - some causes the hero to die (missiles & electric barriers),
 * others give the hero points (coins), others do nothing (regular barriers.
 */
public class Hero extends GameObject {
	private int velocityY;
	private int velocityX;
	private boolean fly;
	private static final int HEIGHT = 50;
	private BufferedImage image;

	public Hero(int x, int y, JFrame frame) {
		super(x, y, frame);
		this.velocityY = 0;
		this.velocityX = 0;
		this.fly = false;
		try {
			image = ImageIO.read(new File("sprites/hero.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void move() {
		if (fly) {
			velocityY += -2;
		} else {
			velocityY += 1;
		}

		if (super.getY() > MainApp.SCREEN_HEIGHT - HEIGHT * 2 && velocityY > 0) {
			velocityY = 0;
			super.setY(MainApp.SCREEN_HEIGHT - HEIGHT * 2);
		}

		if (super.getY() < 0 && velocityY < 0) {
			velocityY = 0;
			super.setY(0);
		}

		if (super.getX() < 250) {
			this.velocityX += 1;
		}

		if (super.getX() > 250) {
			this.velocityX = 0;
			super.setX(250);
		}

		super.setX(super.getX() + velocityX);
		super.setY(getY() + velocityY);
	}

	public void fly() {
		this.fly = true;
	}

	public void stopFlying() {
		this.fly = false;
	}

	@Override
	public Graphics2D drawOn(Graphics2D g) {
		g = (Graphics2D) g.create();
		g.setColor(Color.black);
		g.drawImage(image, super.getX(), super.getY(), HEIGHT, HEIGHT, super.getFrame());
		return g;
	}

	public Rectangle2D.Double getBoundingBox() {
		return new Rectangle2D.Double(super.getX(), super.getY(), 50, 50);
	}

	public void pushBack() {
		this.velocityX = -20;
	}
}
