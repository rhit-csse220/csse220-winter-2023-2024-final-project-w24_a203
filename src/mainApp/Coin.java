package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;

public class Coin extends GameObject{

	public Coin(int x, int y) {
		// TODO Auto-generated constructor stub
		super(x,y);
	}
	
	@Override
	public Graphics2D drawOn(Graphics2D g) {
		// TODO Auto-generated method stub
		g = (Graphics2D)g.create();
		g.setColor(Color.orange);
		g.fillOval(super.getX(), super.getY(), 40, 40);
		return g;
	}

}
