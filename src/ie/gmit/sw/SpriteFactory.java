package ie.gmit.sw;

/**
 * 
 * This class uses the factory design pattern for creating and instantiating
 * multiple sprites.
 *
 */
public class SpriteFactory {

	/**
	 * Instantiates DefaultSprite. Obtains sprites image from resources.
	 * 
	 * @return
	 * @throws Exception
	 */
	public static DefaultSprite defaultInstance() throws Exception {

		DefaultSprite defaultS = new DefaultSprite();

		defaultS.drawSprite(ImageController.loadImages("./resources/images/sprites/default", null));

		return defaultS;
	}

	/**
	 * Instantiates KnightSprite. Obtains sprites image from resources.
	 * 
	 * @return
	 * @throws Exception
	 */
	public static PlayerSprite knightInstance() throws Exception {

		PlayerSprite player = new PlayerSprite();

		player.setName("Knight 1");
		player.setPosition(new Point(0, 0));
		player.drawSprite(ImageController.loadImages("./resources/images/sprites/knight", null));

		return player;
	}

	/**
	 * Instantiates GreenSprite. Obtains sprites image from resources.
	 * 
	 * @return
	 * @throws Exception
	 */
	public static GreenSprite greenGuyInstance() throws Exception {

		GreenSprite greenGuy = new GreenSprite();

		greenGuy.drawSprite(ImageController.loadImages("./resources/images/sprites/green", null));

		return greenGuy;
	}

	/**
	 * Instantiates PersonSprite. Obtains sprites image from resources.
	 * 
	 * @return
	 * @throws Exception
	 */
	public static PersonSprite personInstance() throws Exception {

		PersonSprite person = new PersonSprite();

		person.drawSprite(ImageController.loadImages("./resources/images/sprites/person", null));

		return person;
	}
}
