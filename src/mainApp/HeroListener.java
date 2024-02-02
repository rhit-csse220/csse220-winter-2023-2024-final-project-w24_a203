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
		// TODO Auto-generated method stub
		this.hero.flySet(true);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyChar() == ' ') {
			this.hero.flySet(true);
		}
//		this.hero.flySet(true);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
//		if (e.getKeyChar() == ' ') {
//			hero.flySet(false);
//		}
		this.hero.flySet(true);
	}

}
