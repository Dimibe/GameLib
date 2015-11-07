package dimisjavagamelib.test;

import dimisjavagamelib.GameLib;
import dimisjavagamelib.Orientation;
import dimisjavagamelib.handler.ImageHandler;
import dimisjavagamelib.objects.Actor;

public class Bullet extends Actor {

	private Orientation orientation;
	
	private int speed = 10;

	public Bullet(int posX, int posY, Orientation orientation) {
		super("dimisjavagamelib/res/bullet.png", posX, posY);

		this.orientation = orientation;
		img = ImageHandler.resizeImage(img, 100, 100);

	}

	@Override
	public void update() {
		posX += orientation.getX() * speed;
		posY += orientation.getY() * speed;

		if (isOutOfScreen()) {
			GameLib.getInstance().removeActor(this);
		}
	}

}
