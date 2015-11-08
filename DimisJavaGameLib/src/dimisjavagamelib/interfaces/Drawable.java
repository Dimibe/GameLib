package dimisjavagamelib.interfaces;
import java.awt.Graphics2D;

import dimisjavagamelib.Screen;

/**
 * Each class which implements this Interface can be drawn on the screen
 * @see Screen
 * @author dbegnis
 */
public interface Drawable {
	
	/**
	 *  This method is called each time the screens repaint method is called if the Object ist added to the LinkedList in screen
	 * @param g
	 */
	public abstract void draw(Graphics2D g);

}
