package mainApp;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LevelListener implements KeyListener {
	MainApp app;
	String filename;
	MainComponent component;

	public LevelListener(MainComponent component, String filename, MainApp app) {
		this.filename = filename;
		this.component = component;
		this.app = app;
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyChar() == 'u') {
			filename = "level2.txt";
			System.out.println("U pressed");
			System.out.println("in level 2");
			try {
				component.changeLevel(app.readFile(filename));

			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (ObstacleNotFoundException e1) {
				e1.printStackTrace();
			}

		} else if (e.getKeyChar() == 'd') {
			filename = "level1.txt";
			System.out.println("D pressed");
			System.out.println("in level 1");
			try {
				component.changeLevel(app.readFile(filename));

			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (ObstacleNotFoundException e1) {
				e1.printStackTrace();
			}
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {}

}