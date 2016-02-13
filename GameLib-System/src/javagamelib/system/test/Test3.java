package javagamelib.system.test;

import javagamelib.GameLib;
import javagamelib.handler.ImageHandler;
import javagamelib.handler.JFrameHandler;
import javagamelib.objects.Actor;
import javagamelib.objects.World;

public class Test3 {

	public static Opponent opp;

	public static void main(String[] args) {

		JFrameHandler.createJFrame(800, 600);

		World world = new NewWorld();
		world.activate();

		Actor actor = new Jellyfish(0, 0);
		actor.setImg(ImageHandler.resizeImage(actor.getImageName(), 50, 50));
		actor.activate();

		opp = new Opponent(600, 300);
		opp.setImg(ImageHandler.resizeImage(opp.getImageName(), 50, 50));
		opp.activate();

		GameLib.getInstance().start();
	}
}
