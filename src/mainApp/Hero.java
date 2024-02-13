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
 * TODO: ADD JAVA DOC HERE
 * Class: Hero
 * Purpose: Hero that the player controls. Can interact
 * with each game object - some causes the hero to die (missiles 
 * & electric barriers), others give the hero points (coins),
 * others do nothing (regular barriers.
 */
public class Hero extends GameObject {
	private int velocityY;
	private int velocityX;
	private boolean fly;
	private boolean push;
	private BufferedImage image;
	
	public Hero(int x, int y, JFrame frame) {
		super(x, y, frame);
		this.velocityY = 0;
		this.velocityX = 0;
		this.fly = false;
		this.push= false;
		try {
			image = ImageIO.read(new File("sprites/hero.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void move() {
		if(fly) {
			velocityY = -10;
		}
		else {
			velocityY += 1;
		}
		if(super.getY() > MainApp.SCREEN_HEIGHT - 70 && velocityY > 0) {
			velocityY = 0;
			super.setY(MainApp.SCREEN_HEIGHT - 70);
		}
		if(super.getY() < 0 && velocityY < 0) {
			velocityY = 0;
			super.setY(0);
		}
		if(super.getX()<250) {
			this.velocityX+=1;
		}
		if(super.getX()>250){
			this.velocityX =0;
			super.setX(250);
		}
		super.setX(super.getX()+velocityX);
		super.setY(getY() + velocityY);
	}

	public void fly() {
//		System.out.println(super.getY());
//		if (super.getY() > 0) {
//			velocity = -10;
//		} else {
//			velocity = 0;
//		}
		this.fly = true;
	}

	public void stopFlying() {
//		if (super.getY() > MainApp.SCREEN_HEIGHT -80) {
//			velocity = 0;
//		}else {
//			velocity = 10;
//		}
		this.fly = false;
	}
	
	
	@Override
	public Graphics2D drawOn(Graphics2D g) {
		g = (Graphics2D)g.create();
		g.setColor(Color.black);
		g.drawImage(image, super.getX(), super.getY(), 40, 40, super.getFrame());
//		g.fillRect(super.getX(), super.getY(), 30, 30);
		return g;
	}
	public Rectangle2D.Double getBoundingBox() {
		return new Rectangle2D.Double(super.getX(), super.getY(), 40, 40 );
	}
	public void pushBack() {
		// TODO Auto-generated method stub
//		super.setX(super.getX()-6);
		this.velocityX = -20;
	}
}
