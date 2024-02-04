package mainApp;

import java.awt.Color;

public class Missile extends GameObject{

	public Missile(int x, int y, Color color, Character type) {
		super(x, y, color, type);
	}
	
	@Override
	public void move() {
		super.setX(getX() - 15);
	}

}
