package dimisjavagamelib.objects;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import dimisjavagamelib.GameLoop;
import dimisjavagamelib.interfaces.Drawable;
import dimisjavagamelib.interfaces.Updateable;

public abstract class Actor implements Drawable, Updateable {

	protected int posX;
	protected int posY;

	private BufferedImage img;

	public Actor(String img, int posX, int posY) {
		this();
		try {
			this.img = ImageIO.read(getClass().getClassLoader().getResourceAsStream(img));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.posX = posX;
		this.posY = posY;
	}

	private Actor() {
		GameLoop.getInstance().addActor(this);
	}

	@Override
	public final void draw(Graphics2D g) {
		g.drawImage(img, posX, posY, null);
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
