package dimisjavagamelib;

import java.util.LinkedList;

import dimisjavagamelib.interfaces.Updateable;
import dimisjavagamelib.objects.Actor;

public class GameLoop implements Runnable {

	private static GameLoop loop;

	private boolean running;

	private LinkedList<Actor> actors;
	private LinkedList<Updateable> updateables;

	private Thread thread;
	
	private Screen screen;

	private GameLoop() {
		actors = new LinkedList<>();
		updateables = new LinkedList<>();
		screen = new Screen(800, 600);
		thread = new Thread(this);
	}

	@Override
	public void run() {
		while (running) {

			for (Updateable u : updateables) {
				u.update();
			}
			
			screen.repaint();

			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void start() {
		running = true;
		thread.start();
	}

	public void stop() {
		running = false;
	}

	public void addActor(Actor actor) {
		actors.add(actor);
		updateables.add(actor);
		screen.addDrawable(actor);
	}

	public void removeActor(Actor actor) {
		actors.remove(actor);
		updateables.remove(actor);
		screen.removeDrawable(actor);
	}

	public Screen getScreen() {
		return screen;
	}
	public static GameLoop getInstance() {
		if (loop == null) {
			loop = new GameLoop();
		}
		return loop;
	}

}
