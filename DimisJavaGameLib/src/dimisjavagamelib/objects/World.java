package dimisjavagamelib.objects;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import dimisjavagamelib.GameLib;
import dimisjavagamelib.handler.ImageHandler;
import dimisjavagamelib.interfaces.Drawable;
import dimisjavagamelib.interfaces.Updateable;

/**
 * this class represents a standard collection of functionalities for a world object
 * @author dbegnis
 *
 */
public abstract class World implements Updateable, Drawable {

	private BufferedImage img;

	public World(String img) {
		this.img = ImageHandler.getImage(img);
		ImageHandler.resizeImage(this.img, GameLib.getInstance().getScreen().getSize().width,
				GameLib.getInstance().getScreen().getSize().height);
	}

	public void activate() {
		GameLib.getInstance().setWorld(this);
	}

	@Override
	public void draw(Graphics2D g) {
		g.drawImage(img, 0, 0, img.getWidth(), img.getHeight(), null);
	}
}
