package ie.gmit.sw;

import java.awt.image.BufferedImage;

/**
 * 
 * Abstract interface for abstracting the sprites from the sprite factory.
 *
 */
public interface Spriteable {

	/**
	 * Get name.
	 * 
	 * @return
	 */
	public String getName();

	/**
	 * Set name.
	 * 
	 * @param name
	 */
	public void setName(String name);

	/**
	 * Get position.
	 * 
	 * @return
	 */
	public Point getPosition();

	/**
	 * Set position.
	 * 
	 * @param position
	 */
	public void setPosition(Point position);

	/**
	 * Draw sprite.
	 * 
	 * @param img
	 */
	public void drawSprite(BufferedImage[] img);
}