package ie.gmit.sw;

/**
 * 
 * Class is used for obtaining properties in correspondence with sprite/object
 * images and grid tiles.
 *
 */
public class Properties {

	private static final int DEFAULT_IMAGE_INDEX = 0;
	private static final int DEFAULT_VIEW_SIZE = 1280;
	private static final int TILE_WIDTH = 128;
	private static final int TILE_HEIGHT = 64;

	/**
	 * Get image index
	 * 
	 * @return
	 */
	public static int getDefaultImageIndex() {
		return DEFAULT_IMAGE_INDEX;
	}

	/**
	 * Get frame size
	 * 
	 * @return
	 */
	public static int getDefaultViewSize() {
		return DEFAULT_VIEW_SIZE;
	}

	/**
	 * Get tile width
	 * 
	 * @return
	 */
	public static int getTileWidth() {
		return TILE_WIDTH;
	}

	/**
	 * Get tile height
	 * 
	 * @return
	 */
	public static int getTileHeight() {
		return TILE_HEIGHT;
	}
}
