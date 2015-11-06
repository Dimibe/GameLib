package dimisjavagamelib.objects;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import dimisjavagamelib.GameLib;
import dimisjavagamelib.handler.ImageHandler;
import dimisjavagamelib.interfaces.Drawable;
import dimisjavagamelib.interfaces.Updateable;

public abstract class World implements Updateable, Drawable {
	
	private BufferedImage img;
	
	public World(String img) {
		this();
		this.img = ImageHandler.loadImage(img);
		ImageHandler.resizeImage(this.img, GameLib.getInstance().getScreen().getWidth(), GameLib.getInstance().getScreen().getHeight());
	}
	
	private World() {
		GameLib.getInstance().setWorld(this);
	}

	@Override
	public void draw(Graphics2D g) {
		g.drawImage(img, 0, 0, img.getWidth(), img.getHeight(), null);
	}
}
