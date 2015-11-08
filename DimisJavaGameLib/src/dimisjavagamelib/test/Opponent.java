package dimisjavagamelib.test;

import dimisjavagamelib.GameLib;
import dimisjavagamelib.objects.Actor;

public class Opponent extends Actor {

	public Opponent(int posX, int posY) {
		super("dimisjavagamelib/res/JellyFish.jpg", posX, posY);
	}

	@Override
	public void update() {
		
	}

	public void remove() {
		GameLib.getInstance().removeActor(this);
	}

}
