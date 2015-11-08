package dimisjavagamelib;

import java.util.LinkedList;

import dimisjavagamelib.interfaces.Updateable;
import dimisjavagamelib.objects.Actor;
import dimisjavagamelib.objects.World;

/**
 * Dimi's Java Game Library
 * 
 * @since 8.11.2015
 * @version 3.3
 * 
 * @author dbegnis
 *
 */
public class GameLib implements Runnable {

	private static GameLib loop;

	private boolean running;

	private LinkedList<Actor> actors;
	private LinkedList<Updateable> updateables;
	
	private World world;

	private Thread thread;

	private Screen screen;

	private GameLib() {
		actors = new LinkedList<>();
		updateables = new LinkedList<>();
		thread = new Thread(this);
	}

	@Override
	public void run() {
		while (running) {

			for (int i = 0; i < updateables.size(); i++) {
				updateables.get(i).update();
			}

			screen.repaint();

			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.exit(0);
	}

	public void start() {
		running = true;
		thread.start();
	}

	public void stop() {
		running = false;
	}
	
	public void setupScreen(int w, int h) {
		screen = new Screen(w,h);
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

	public void addUpdateable(Updateable updateable) {
		updateables.add(updateable);
	}

	public void removeUpdateable(Updateable updateable) {
		updateables.remove(updateable);
	}

	public Screen getScreen() {
		return screen;
	}

	public static GameLib getInstance() {
		if (loop == null) {
			loop = new GameLib();
		}
		return loop;
	}

	public void setWorld(World world) {
		this.world = world;
		updateables.add(world);
		screen.addDrawable(world);
	}
	
	public void removeWorld() {
		updateables.remove(world);
		screen.removeDrawable(world);
	}

}
