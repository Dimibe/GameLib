package dimisjavagamelib.test;

import java.awt.event.KeyEvent;

import dimisjavagamelib.Orientation;
import dimisjavagamelib.handler.InputHandler;
import dimisjavagamelib.objects.Actor;

public class Jellyfish extends Actor {
	
	private Orientation orientation;
	
	public Jellyfish(int posX, int posY) {
		super("src/dimisjavagamelib/res/JellyFish.jpg", posX, posY);
	}

	@Override
	public void update() {
		if (InputHandler.isKeyDown(KeyEvent.VK_W)) {
			rect.y -= 5;
			orientation = Orientation.NORTH;
		}
		if (InputHandler.isKeyDown(KeyEvent.VK_A)) {
			rect.x -= 5;
			orientation = Orientation.WEST;
		}
		if (InputHandler.isKeyDown(KeyEvent.VK_S)) {
			rect.y += 5;
			orientation = Orientation.SOUTH;
		}
		if (InputHandler.isKeyDown(KeyEvent.VK_D)) {
			rect.x += 5;
			orientation = Orientation.EAST;
		}
		
		if (InputHandler.isKeyDown(KeyEvent.VK_SPACE)) {
			new Bullet(rect.x, rect.y, orientation).activate();
		}
	}

}
