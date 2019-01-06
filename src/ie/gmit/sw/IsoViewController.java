package ie.gmit.sw;

/**
 * 
 * This class is used for controlling and setting up the isometric view. Methods
 * inside this class keeps the SRP.
 *
 */
public class IsoViewController {

	/**
	 * Gets X coordinate of isometric view.
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public int getIsoX(int x, int y) {
		int rshift = (Properties.getDefaultViewSize() / 2) - (Properties.getTileWidth() / 2) + (x - y); // Pan camera to
																										// the right
		return (x - y) * (Properties.getTileWidth() / 2) + rshift;
	}

	/**
	 * Gets Y coordinate of isometric view.
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public int getIsoY(int x, int y) {
		return (x + y) * (Properties.getTileHeight() / 2);
	}

	/**
	 * Gets coordinates of isometric view and returns a point.
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public Point getIso(int x, int y) {
		return new Point(getIsoX(x, y), getIsoY(x, y)); // Could be more efficient...
	}

}
