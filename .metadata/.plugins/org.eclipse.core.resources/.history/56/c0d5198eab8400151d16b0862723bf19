package dimisjavagamelib.test.one;

import java.awt.event.KeyEvent;

import dimisjavagamelib.handler.InputHandler;
import dimisjavagamelib.objects.Actor;

public class Jellyfish extends Actor {
	
	public Jellyfish(String img, int posX, int posY) {
		super(img, posX, posY);
	}

	@Override
	public void update() {
		if (InputHandler.isKeyDown(KeyEvent.VK_S)) {
			posY += 5;
		}
	}

}
