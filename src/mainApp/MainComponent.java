package mainApp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Class: MainComponent <br>
 * Purpose: Used to draw Coins, hero, ElctricBarriers, Barriers, Missiles, and
 * trackerMissiles. Also, this class changes the level of the game, and hold
 * display information about point and lives. <br>
 * For example:
 * 
 * <pre>
 * MainComponent mainComponent = new MainComponent(listOfObjects, hero, frame);
 * </pre>
 */
public class MainComponent extends JComponent {

	private ArrayList<Missile> missiles = new ArrayList<Missile>();
	private ArrayList<Barrier> barriers = new ArrayList<Barrier>();
	private ArrayList<ElectricBarrier> electricBarriers = new ArrayList<ElectricBarrier>();
	private ArrayList<Coin> coins = new ArrayList<Coin>();
	private boolean IfGameIsOver;

	private ArrayList<GameObject> listOfObjects;
	private Hero hero;
	private int points = 0;
	private int lives = 3;
	private int previousLives = 3;
	private JFrame frame;
	private BufferedImage image;
	private BufferedImage imageGameOver;
	private int x;

	public MainComponent(ArrayList<GameObject> listOfObjects, Hero hero, JFrame frame) {
		System.out.println("In MainComponent File");
		this.listOfObjects = listOfObjects;
		this.createArrayListsOfObjects();
		this.hero = hero;
		HeroListener heroListener = new HeroListener(hero);
		this.addKeyListener(heroListener);
		this.IfGameIsOver = false;
		this.frame = frame;
		try {
			image = ImageIO.read(new File("sprites/background.png"));
			imageGameOver = ImageIO.read(new File("sprites/gameOver.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.x = 0;
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		if (!IfGameIsOver) {
			removeObjects();
			if (lives > 0) {
				g.drawImage(image, this.x, 0, MainApp.SCREEN_WIDTH * 3, MainApp.SCREEN_HEIGHT, this.frame);
				x += -5;
				if (this.x < -MainApp.SCREEN_WIDTH * 2) {
					this.x = 0;
				}
				for (Missile missle : missiles) {
					missle.drawOn(g2);
					if (missle.ifCollidedWithHero() == false && missle.collidedWithHero(hero)) {
						lives -= 1;
						break;
					}
				}
				for (Barrier barrier : barriers) {
					barrier.drawOn(g2);
					if (barrier.collidedWithHero(hero)) {
						hero.pushBack();
					}

				}
				for (ElectricBarrier ebarrier : electricBarriers) {
					ebarrier.drawOn(g2);
					if (ebarrier.collidedWithHero(hero)) {
						lives -= 1;
					}
				}
				for (Coin coin : coins) {
					coin.drawOn(g2);
					if (coin.collidedWithHero(hero)) {
						points += 1;
						break;
					}

				}
				hero.drawOn(g2);
				g2.setColor(Color.white);
				g2.drawString("Points: " + points, 10, 20);
				g2.drawString("Lives : " + lives, 925, 20);
				super.paintComponent(g);
			} else { // LOSING SCREEN
				g.drawImage(imageGameOver, 0, 0, MainApp.SCREEN_WIDTH, MainApp.SCREEN_HEIGHT, this.frame);
				g2.setColor(Color.white);
				g2.drawString("YOU LOSE :(", MainApp.SCREEN_WIDTH / 2, MainApp.SCREEN_HEIGHT / 4);
			}
		} else { // WINNING SCREEN
			g.drawImage(imageGameOver, 0, 0, MainApp.SCREEN_WIDTH, MainApp.SCREEN_HEIGHT, this.frame);
			g2.setColor(Color.white);
			g2.drawString("YOU WON :)", MainApp.SCREEN_WIDTH / 2, MainApp.SCREEN_HEIGHT / 4);
		}
	} // paintComponent

	public void move() {
		hero.move();
		for (GameObject object : listOfObjects) {
			object.move();
		}
	}

	public void removeObjects() {
		ArrayList<GameObject> objectsToRemove = new ArrayList<GameObject>();
		for (GameObject object : listOfObjects) {
			if (object.getX() < 0) {
				objectsToRemove.add(object);
			}
		}
		missiles.removeAll(objectsToRemove);
		coins.removeAll(objectsToRemove);
		barriers.removeAll(objectsToRemove);
		electricBarriers.removeAll(objectsToRemove);
	}

	public void changeLevel(ArrayList<GameObject> objects) {
		listOfObjects = objects;
		this.createArrayListsOfObjects();
	}

	public void createArrayListsOfObjects() {
		barriers.removeAll(barriers);
		electricBarriers.removeAll(electricBarriers);
		coins.removeAll(coins);
		missiles.removeAll(missiles);
		for (GameObject object : listOfObjects) {
			if (object instanceof Barrier) {
				barriers.add((Barrier) object);
			} else if (object instanceof ElectricBarrier) {
				electricBarriers.add((ElectricBarrier) object);
			} else if (object instanceof Coin) {
				coins.add((Coin) object);
			} else if (object instanceof Missile) {
				missiles.add((Missile) object);
			}
		}
	}

	@Override
	public boolean isFocusable() {
		return true;
	}

	public boolean collideWithMissile() {
		if (previousLives != lives) {
			previousLives = lives;
			return true;
		} else {
			return false;
		}
	}

	public boolean isLevelCompleted() {
		if (missiles.isEmpty() && barriers.isEmpty() && electricBarriers.isEmpty() && coins.isEmpty()) {
			return true;
		}
		return false;
	}

	public void setLives(int lives) {
		this.lives = lives;
		this.points = 0;
	}

	public void setGameOver(boolean gameState) {
		IfGameIsOver = gameState;
	}
}
