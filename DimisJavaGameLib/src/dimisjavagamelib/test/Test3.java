package dimisjavagamelib.test;

import dimisjavagamelib.GameLib;
import dimisjavagamelib.handler.ImageHandler;
import dimisjavagamelib.handler.JFrameHandler;
import dimisjavagamelib.objects.Actor;
import dimisjavagamelib.objects.World;

public class Test3 {
	
	public static Opponent opp;

	public static void main(String[] args) {

		JFrameHandler.createJFrame(800, 600);
		
		World world = new NewWorld();
		world.activate();
		
		Actor actor = new Jellyfish(0, 0);
		actor.setImg(ImageHandler.resizeImage(actor.getImg(), 50, 50));
		actor.activate();
		

		opp = new Opponent(600, 300);
		opp.setImg(ImageHandler.resizeImage(opp.getImg(), 50, 50));
		opp.activate();

		GameLib.getInstance().start();
	}
}
