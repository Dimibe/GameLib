package javagamelib.system.test;

import javagamelib.GameLib;
import javagamelib.Orientation;
import javagamelib.handler.ImageHandler;
import javagamelib.objects.Actor;

/**
 * 
 * @author dbegnis
 *
 */
public class Bullet extends Actor {

	private Orientation orientation;

	private int speed = 10;

	public Bullet(int posX, int posY, Orientation orientation) {
		super("dimisjavagamelib/res/bullet.png", posX, posY);
		this.orientation = orientation;
		setImg(ImageHandler.resizeImage(getImageName(), 100, 100));

	}

	@Override
	public void update() {
		rect.x += orientation.getX() * speed;
		rect.y += orientation.getY() * speed;
		if (isOutOfScreen()) {
			GameLib.getInstance().removeActor(this);
		}
		if (Test3.opp == null) {
			return;
		}
		if (intersects(Test3.opp)) {
			Test3.opp.remove();
			Test3.opp = null;
			GameLib.getInstance().removeActor(this);
		}
	}

}
