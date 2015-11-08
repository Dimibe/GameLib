package dimisjavagamelib.test;

import java.awt.event.KeyEvent;

import dimisjavagamelib.GameLib;
import dimisjavagamelib.handler.ImageHandler;
import dimisjavagamelib.handler.InputHandler;
import dimisjavagamelib.handler.JFrameHandler;
import dimisjavagamelib.interfaces.Updateable;
import dimisjavagamelib.objects.Actor;

/**
 * Test for GameLib Version 2.0
 * 
 * @author dbegnis
 *
 */
public class Test2 implements Updateable {

	public static void main(String[] args) {

		JFrameHandler frameHandler = JFrameHandler.createJFrame(800, 600);
		frameHandler.add(GameLib.getInstance().getScreen());

		Actor actor = new Jellyfish(0, 0);
		actor.setImg(ImageHandler.resizeImage(actor.getImg(), 50, 50));
		GameLib.getInstance().start();

		GameLib.getInstance().addUpdateable(new Test2());

	}

	@Override
	public void update() {
		if (InputHandler.isKeyDown(KeyEvent.VK_ESCAPE)) {
			GameLib.getInstance().stop();
		}
	}
}
