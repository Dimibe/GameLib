package dimisjavagamelib.objects;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import dimisjavagamelib.GameLib;
import dimisjavagamelib.handler.ImageHandler;
import dimisjavagamelib.interfaces.Drawable;
import dimisjavagamelib.interfaces.Updateable;

public abstract class Actor implements Drawable, Updateable {

	protected int posX;
	protected int posY;

	protected BufferedImage img;

	public Actor(String img, int posX, int posY) {
		this.img = ImageHandler.loadImage(img);
		this.posX = posX;
		this.posY = posY;
	}

	public void activate() {
		GameLib.getInstance().addActor(this);
	}

	@Override
	public final void draw(Graphics2D g) {
		g.drawImage(img, posX, posY, null);
	}

	/**
	 * 
	 * @return Returns true if the actor is completely out of screen
	 */
	public boolean isOutOfScreen() {
		return (posX + img.getWidth() < 0 || posX > GameLib.getInstance().getScreen().getWidth())
				|| (posY + img.getHeight() < 0 || posY > GameLib.getInstance().getScreen().getHeight());
	}
	/**
	 *  Returns true is the actor is completely on the screen
	 *  
	 */
	public boolean isInBounds() {
		return !((posX < 0 || posX + img.getWidth() > GameLib.getInstance().getScreen().getWidth())
				|| (posY < 0 || posY + img.getHeight() > GameLib.getInstance().getScreen().getHeight()));
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public BufferedImage getImg() {
		return img;
	}

	public void setImg(BufferedImage img) {
		this.img = img;
	}

}
