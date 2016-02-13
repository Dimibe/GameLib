package javagamelib.objects;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javagamelib.GameLib;
import javagamelib.handler.ImageHandler;
import javagamelib.interfaces.Drawable;
import javagamelib.interfaces.Updateable;

/**
 * this class represents a standard collection of functionalities for a world object
 * @author dbegnis
 *
 */
public abstract class World implements Updateable, Drawable {

	private BufferedImage img;
	
	private String imageName;

	public World(String img) {
		imageName = img;
		this.img = ImageHandler.getImage(img);
		ImageHandler.resizeImage(imageName, GameLib.getInstance().getScreen().getSize().width,
				GameLib.getInstance().getScreen().getSize().height);
	}

	public void activate() {
		GameLib.getInstance().setWorld(this);
	}

	@Override
	public void draw(Graphics2D g) {
		g.drawImage(img, 0, 0, img.getWidth(), img.getHeight(), null);
	}
	
	public String getImageName() {
		return imageName;
	}
}
