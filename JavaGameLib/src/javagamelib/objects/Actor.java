package javagamelib.objects;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javagamelib.GameLib;
import javagamelib.handler.ImageHandler;
import javagamelib.interfaces.Drawable;
import javagamelib.interfaces.Updateable;

/**
 * this abstract class represents a standard collection with functionalities for objects in the Game 
 * @author dbegnis
 *
 */
public abstract class Actor implements Drawable, Updateable {

	protected Rectangle rect;

	private BufferedImage img;
	private String imageName;

	public Actor(String img, int posX, int posY) {
		imageName = img;
		rect = new Rectangle(posX, posY);
		setImg(ImageHandler.getImage(img));
		rect.x = posX;
		rect.y = posY;
	}

	public void activate() {
		GameLib.getInstance().addActor(this);
	}

	@Override
	public final void draw(Graphics2D g) {
		g.drawImage(img, rect.x, rect.y, rect.width, rect.height, null);
	}

	/**
	 * 
	 * @return Returns true if the actor is completely out of screen
	 */
	public boolean isOutOfScreen() {
		return (rect.x + img.getWidth() < 0 || rect.x > GameLib.getInstance().getScreen().getWidth())
				|| (rect.y + img.getHeight() < 0 || rect.y > GameLib.getInstance().getScreen().getHeight());
	}

	/**
	 * 
	 * @return Returns true is the actor is completely on the screen
	 */
	public boolean isInBounds() {
		return !((rect.x < 0 || rect.x + img.getWidth() > GameLib.getInstance().getScreen().getWidth())
				|| (rect.y < 0 || rect.y + img.getHeight() > GameLib.getInstance().getScreen().getHeight()));
	}

	/**
	 * 
	 * @param actor
	 * @return Returns true if this actor intersects with the given actor
	 */
	public boolean intersects(Actor actor) {
		return this.rect.intersects(actor.rect);
	}

	public int getPosX() {
		return rect.x;
	}

	public void setPosX(int posX) {
		this.rect.x = posX;
	}

	public int getPosY() {
		return rect.y;
	}

	public void setPosY(int posY) {
		this.rect.y = posY;
	}

	public BufferedImage getImg() {
		return img;
	}
	
	public String getImageName() {
		return imageName;
	}

	public void setImg(BufferedImage img) {
		this.img = img;
		rect.width = img.getWidth();
		rect.height = img.getHeight();
	}

}
