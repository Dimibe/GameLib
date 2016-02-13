package javagamelib;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferStrategy;
import java.util.LinkedList;

import javagamelib.handler.InputHandler;
import javagamelib.interfaces.Drawable;

/**
 * The Canvas on which all the actors and the world is displayed
 * 
 * @author dbegnis
 *
 */
public class Screen extends Canvas {
	private static final long serialVersionUID = 1L;

	private LinkedList<Drawable> drawables;

	private Dimension size;

	public Screen(int width, int height) {
		drawables = new LinkedList<>();

		size = new Dimension(width, height);

		setPreferredSize(size);
		setMaximumSize(size);
		setMinimumSize(size);

		addKeyListener(new InputHandler());
		addMouseListener(new InputHandler());
		addMouseMotionListener(new InputHandler());
	}

	public void repaint() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(2);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		draw(g2d);
		g.dispose();
		bs.show();

	}

	private void draw(Graphics2D g) {
		g.clearRect(0, 0, size.width, size.width);
		for (int i = 0; i < drawables.size(); i++) {
			drawables.get(i).draw(g);
		}
	}

	public void addDrawable(Drawable drawable) {
		drawables.add(drawable);
	}

	public void removeDrawable(Drawable drawable) {
		drawables.remove(drawable);
	}

	public Dimension getSize() {
		return size;
	}
}
