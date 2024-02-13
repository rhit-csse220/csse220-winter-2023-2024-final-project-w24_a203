package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Coin extends GameObject {

	/**
	 * DONE: ADD JAVA DOCS Class: Coin Purpose: Coins that hero can collect. Hero
	 * gets points for each coin collected. After a coin is collected, it disappears
	 * from screen.
	 * @param frame 
	 */
	private Image image;
	public Coin(int x, int y, JFrame frame) {
		super(x, y, frame);
		try {
			image = ImageIO.read(new File("sprites/coin.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Graphics2D drawOn(Graphics2D g) {
		g = (Graphics2D) g.create();
		g.setColor(Color.orange);
		g.drawImage(image, super.getX(), super.getY(), 40, 40, super.getFrame());
//		g.fillOval(super.getX(), super.getY(), 40, 40);
		return g;
	}

	@Override
	public boolean collidedWithHero(Hero hero) {
		if(super.collidedWithHero(hero)) {
			//System.out.println("Collided with coin");
			setX(-10); //removes the coin from JFrame
			return true;
		}else {
			return false;
		}
	}

	public void removeCoin() {

	}

}
