package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;

public class Barrier extends GameObject{

	private int angle;
	
	public Barrier(int x, int y) {
		// TODO Auto-generated constructor stub
		super(x,y);
		this.angle = (int) rand.nextDouble(-3.14/2, 3.14/2);
	}
	
	@Override
	public Graphics2D drawOn(Graphics2D g) {
		// TODO Auto-generated method stub
		g = (Graphics2D)g.create();
		g.setColor(Color.pink);
		g.rotate(angle, super.getX(), super.getY());
		g.fillRect(super.getX(), super.getY(), 20, 200);
		return g;
	}
}
