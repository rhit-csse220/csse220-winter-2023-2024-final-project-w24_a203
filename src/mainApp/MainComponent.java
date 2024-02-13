package mainApp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * TODO: ADD JAVA DOC HERE
 */
public class MainComponent extends JComponent {

//	Hero hero = new Hero(200, 500);
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
	
	public MainComponent(ArrayList<GameObject> listOfObjects, Hero hero) {
		System.out.println("In MainComponent File");
		this.listOfObjects = listOfObjects;
		this.createArrayListsOfObjects();
		this.hero = hero;
		HeroListener heroListener = new HeroListener(hero);
		this.addKeyListener(heroListener);
		this.IfGameIsOver = false;
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		if(!IfGameIsOver) {
		removeObjects();
		if(lives>0) {
		for (Missile missle : missiles) {
			missle.drawOn(g2);
			if( missle.ifCollidedWithHero()==false && missle.collidedWithHero(hero)) {
				lives -= 1;
				break;
			}
		}
//		if(previousLives != lives) {
//			previousLives = lives;
//			System.out.println("Restart the level");
//			this.createArrayListsOfObjects();
//		}
		for (Barrier barrier : barriers) {
			barrier.drawOn(g2);
			if(barrier.collidedWithHero(hero)) {
				hero.pushBack();
			}
		
		}
		for (ElectricBarrier ebarrier : electricBarriers) {
			ebarrier.drawOn(g2);
			if(ebarrier.collidedWithHero(hero)) {
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
		g2.drawString("Points: " + points, 10, 20);
		g2.drawString("Lives : " + lives, 900, 20);
		super.paintComponent(g);
		}
		else {
//			g.setColor(Color.);
//			g.drawIm(0, 0, 1000, 800);
			g.drawString("GAME OVER", 200, 200);
			g.drawString("TEST", 250, 250);
			
// TODO: add jbuttons to restart game?
//			JPanel panel = new JPanel();
//			
//			JButton exitGameButton = new JButton("EXIT GAME");
//			JButton restartGameButton = new JButton("RESTART GAME");
//			
//			panel.add(exitGameButton);
//			panel.add(restartGameButton);
//			System.out.println("panel added");


			
		}
		}
		else {
			g2.setColor(Color.cyan);
			g2.fillRect(0, 0, MainApp.SCREEN_WIDTH, MainApp.SCREEN_HEIGHT);
			g2.setColor(Color.black);
			g2.drawString("GameOver",MainApp.SCREEN_WIDTH/2, MainApp.SCREEN_HEIGHT/2);
			g2.drawString("If you want to play again press R", MainApp.SCREEN_WIDTH/2, MainApp.SCREEN_HEIGHT/2 + 30);
			g2.drawString("If you want to exit press E", MainApp.SCREEN_WIDTH/2, MainApp.SCREEN_HEIGHT/2 + 60);
		}
	}

	// TODO: Add java doc
	public void move() {
		hero.move();
		for (GameObject object : listOfObjects) {
			object.move();
		}
	}

	// TODO: Add java docs
	public void removeObjects() {
		ArrayList<GameObject> objectsToRemove = new ArrayList<GameObject>();
		for (GameObject object : listOfObjects) {
			if (object.getX() < 0) {
				objectsToRemove.add(object);
			}
		}
		//listOfObjects.removeAll(objectsToRemove);
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
		if(previousLives != lives) {
			previousLives = lives;
			return true;
		}else {
			return false;
		}
	}
	
	public boolean isLevelCompleted() {
		if(missiles.isEmpty() && barriers.isEmpty() && electricBarriers.isEmpty() && coins.isEmpty()) {
			return true;
		}
		return false;
	}

	public void setGameOver(boolean gameState) {
		// TODO Auto-generated method stub
		IfGameIsOver = gameState;
	}

}
