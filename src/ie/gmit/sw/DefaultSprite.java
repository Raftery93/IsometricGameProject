package ie.gmit.sw;

import java.awt.image.BufferedImage;

/**
 * 
 * Class is used for defining information about DefaultSprite.
 *
 */
public class DefaultSprite implements Spriteable {
	private String name; // The name of the sprite
	private BufferedImage[][] images = new BufferedImage[4][3]; // The images used in the animation
	private Direction direction = Direction.DOWN; // The current orientation of the sprite
	private int index = 0; // The current image index.
	private Point position; // The current x, y position

	public DefaultSprite() {
		super();
	}

	/**
	 * Constructor for defining the name and position of sprite.
	 * 
	 * @param name
	 * @param p
	 */
	public DefaultSprite(String name, Point p) {
		super();
		this.name = name;
		this.position = p;
	}

	/**
	 * Loop through images to draw sprite.
	 */
	@Override
	public void drawSprite(BufferedImage[] img) {
		int row = 0, col = 0;
		for (int i = 0; i < img.length; i++) {
			images[row][col] = img[i];
			if (col == images[row].length - 1) {
				row++;
				col = 0;
			} else {
				col++;
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ie.gmit.sw.Spriteable#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ie.gmit.sw.Spriteable#setName(java.lang.String)
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ie.gmit.sw.Spriteable#getPosition()
	 */
	@Override
	public Point getPosition() {
		return position;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ie.gmit.sw.Spriteable#setPosition(ie.gmit.sw.Point)
	 */
	@Override
	public void setPosition(Point position) {
		this.position = position;
	}

	/**
	 * Get image and orientation.
	 * 
	 * @return
	 */
	public BufferedImage getImage() {
		return images[direction.getOrientation()][index];
	}

	/**
	 * Cycle through sprites images if player is moved and change sprites direction.
	 * 
	 * @param d
	 * @return
	 */
	public BufferedImage step(Direction d) {
		setDirection(d);
		if (index < images[direction.getOrientation()].length - 1) {
			index++;
		} else {
			index = 0;
		}

		return images[d.getOrientation()][index];
	}

	/**
	 * Set direction
	 * 
	 * @param d
	 */
	public void setDirection(Direction d) {
		direction = d;
	}

	/**
	 * Get direction
	 * 
	 * @return
	 */
	public Direction getDirection() {
		return this.direction;
	}
}
