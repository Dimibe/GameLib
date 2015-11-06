package dimisjavagamelib.test.one;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import dimisjavagamelib.GameLoop;

/**
 * Test for GameLib version 1.0
 * @author dbegnis
 *
 */
public class Test1 {

	public static void main(String[] args) {

		JFrame frame = new JFrame();
		frame.setSize(800, 600);
		frame.add(GameLoop.getInstance().getScreen());
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.requestFocus();
		
		new Jellyfish("dimisjavagamelib/res/JellyFish.jpg", 0, 0);
		GameLoop.getInstance().start();
	}
}
