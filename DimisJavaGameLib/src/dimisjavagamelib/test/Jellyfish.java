package dimisjavagamelib.test;

import java.awt.event.KeyEvent;

import dimisjavagamelib.Orientation;
import dimisjavagamelib.handler.InputHandler;
import dimisjavagamelib.objects.Actor;

public class Jellyfish extends Actor {
	
	private Orientation orientation;
	
	public Jellyfish(int posX, int posY) {
		super("dimisjavagamelib/res/JellyFish.jpg", posX, posY);
	}

	@Override
	public void update() {
		if (InputHandler.isKeyDown(KeyEvent.VK_W)) {
			posY -= 5;
			orientation = Orientation.UP;
		}
		if (InputHandler.isKeyDown(KeyEvent.VK_A)) {
			posX -= 5;
			orientation = Orientation.LEFT;
		}
		if (InputHandler.isKeyDown(KeyEvent.VK_S)) {
			posY += 5;
			orientation = Orientation.DOWN;
		}
		if (InputHandler.isKeyDown(KeyEvent.VK_D)) {
			posX += 5;
			orientation = Orientation.RIGHT;
		}
		
		if (InputHandler.isKeyDown(KeyEvent.VK_SPACE)) {
			new Bullet(posX, posY, orientation).activate();
		}
	}

}
