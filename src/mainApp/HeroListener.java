package mainApp;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class HeroListener implements KeyListener{

	private Hero hero;
	public HeroListener(Hero hero) {
		this.hero = hero;
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyChar() == ' ') {
			this.hero.fly();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyChar() == ' ') {
			this.hero.stopFlying();
		}
	}

}
