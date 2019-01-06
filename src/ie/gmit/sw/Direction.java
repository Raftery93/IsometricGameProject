package ie.gmit.sw;

/*
 * This enum is used to change the direction and get the orientation of the sprites
 * it can be used for any character sprite
 * */
public enum Direction {
	UP(0), DOWN(1), LEFT(2), RIGHT(3);

	private final int orientation;

	private Direction(int orientation) {
		this.orientation = orientation;
	}

	public int getOrientation() {
		return this.orientation;
	}
}