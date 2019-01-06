package ie.gmit.sw;

/**
 * 
 * Class is used to get and set point coordinate.
 *
 */
public class Point {
	private int x;
	private int y;

	/**
	 * Constructor for X and Y coordinate.
	 * 
	 * @param x
	 * @param y
	 */
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	/**
	 * Get X coordinate.
	 * 
	 * @return
	 */
	public int getX() {
		return x;
	}

	/**
	 * Set X coordinate.
	 * 
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Get Y coordinate.
	 * 
	 * @return
	 */
	public int getY() {
		return y;
	}

	/**
	 * Set Y coordinate.
	 * 
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}
}