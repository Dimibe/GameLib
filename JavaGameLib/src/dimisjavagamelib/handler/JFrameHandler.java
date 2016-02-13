package dimisjavagamelib.handler;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import dimisjavagamelib.GameLib;

/**
 * This class can be used to create predefined JFrames
 * @author dbegnis
 *
 */
public class JFrameHandler {

	private JFrame frame;
	
	private JFrameHandler(int width, int height) {
		this(width, height, width, height);
	}

	private JFrameHandler(int width, int height, int  screen_w, int screen_h) {
		frame = new JFrame();
		frame.setSize(new Dimension(width, height));
		frame.setResizable(false);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		GameLib.getInstance().setupScreen(screen_w, screen_h);
		frame.add(GameLib.getInstance().getScreen());
		
		frame.setVisible(true);
	}

	public static JFrameHandler createJFrame(int width, int height) {
		return new JFrameHandler(width, height);
	}

	public void setUndecorated(boolean b) {
		frame.setUndecorated(b);
	}

	public void add(Component comp) {
		frame.add(comp);
	}
}
