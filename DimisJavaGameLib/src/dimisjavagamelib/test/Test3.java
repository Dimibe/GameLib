package dimisjavagamelib.test;

import dimisjavagamelib.GameLib;
import dimisjavagamelib.handler.ImageHandler;
import dimisjavagamelib.handler.JFrameHandler;
import dimisjavagamelib.objects.Actor;

public class Test3 {

	public static void main(String[] args) {

		JFrameHandler frameHandler = JFrameHandler.createJFrame(800, 600);
		frameHandler.add(GameLib.getInstance().getScreen());

		new NewWorld("dimisjavagamelib/res/Desert.jpg");
		
		Actor actor = new Jellyfish("dimisjavagamelib/res/JellyFish.jpg", 0, 0);
		actor.setImg(ImageHandler.resizeImage(actor.getImg(), 50, 50));

		GameLib.getInstance().start();
	}
}
