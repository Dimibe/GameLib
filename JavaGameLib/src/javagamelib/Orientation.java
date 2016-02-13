package javagamelib;

/**
 * Represents a standart Vector in one of each Orientations
 * 
 * @author dbegnis
 *
 */
public enum Orientation {
	WEST(-1, 0), EAST(1, 0), NORTH(0, -1), SOUTH(0, 1);

	private int x;
	private int y;

	private Orientation(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
