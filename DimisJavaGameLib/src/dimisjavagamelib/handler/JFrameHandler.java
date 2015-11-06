package dimisjavagamelib.handler;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class JFrameHandler {
	
	private JFrame frame;
	
	
	private JFrameHandler(int w, int h) {
		frame = new JFrame();
		frame.setSize(new Dimension(w, h));
		frame.setResizable(false);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
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
