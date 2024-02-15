package mainApp;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/*
 * Class: HeroListener
 * Purpose: Connects the Hero character to the keyboard.
 * The hero can move up with the space bar or the up
 * arrow key.
 */
public class HeroListener implements KeyListener {

	private Hero hero;

	public HeroListener(Hero hero) {
		this.hero = hero;
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyChar() == ' ' || e.getKeyCode() == 38) {
			this.hero.fly();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyChar() == ' ' || e.getKeyCode() == 38) {
			this.hero.stopFlying();
		}
	}
}
