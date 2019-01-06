package ie.gmit.sw;

import javax.swing.JOptionPane;

/**
 * 
 * This class controls the gameplay needed for game interaction. These
 * interactions include communicating with other sprites, collecting chests, and
 * winning the game.
 *
 */
public class GameController {

	// Getting coordinates of each item and sprite
	private PlayerSprite player;
	private Point chestPoint1 = new Point(5, 6);
	private Point chestPoint2 = new Point(7, 1);
	private Point chestPoint3 = new Point(8, 7);
	private Point greenGuy = new Point(3, 2);
	private Point defaultGuy = new Point(5, 8);
	private Point playerGuy = new Point(1, 7);
	private Point sign = new Point(2, 3);
	private Point hole = new Point(9, 2);
	private static boolean c1 = false, c2 = false, c3 = false;

	/**
	 * Constructor for obtaining players position
	 * 
	 * @param player
	 */
	public GameController(PlayerSprite player) {
		super();
		this.player = player;
	}

	/**
	 * Method contains if statements for interactions. Each if statement checks
	 * players position with item/sprite position. If interaction is made, prompt
	 * user with JOptionPane message, and then move players position as to avoid
	 * looping
	 */
	public void gamePlay() {

		if (player.getPosition().getX() == chestPoint1.getX() && player.getPosition().getY() == chestPoint1.getY()) {
			player.setPosition(new Point(6, 6));
			JOptionPane.showMessageDialog(null, "Chest 1 collected", "InfoBox: " + "Progress!",
					JOptionPane.INFORMATION_MESSAGE);
			// Collect chest
			c1 = true;
		}
		if (player.getPosition().getX() == chestPoint2.getX() && player.getPosition().getY() == chestPoint2.getY()) {
			player.setPosition(new Point(7, 2));
			JOptionPane.showMessageDialog(null, "Chest 2 collected", "InfoBox: " + "Progress!",
					JOptionPane.INFORMATION_MESSAGE);
			// Collect chest
			c2 = true;
		}
		if (player.getPosition().getX() == chestPoint3.getX() && player.getPosition().getY() == chestPoint3.getY()) {
			player.setPosition(new Point(8, 8));
			JOptionPane.showMessageDialog(null, "Chest 3 collected", "Info: " + "Progress!",
					JOptionPane.INFORMATION_MESSAGE);
			// Collect chest
			c3 = true;
		}
		if (player.getPosition().getX() == greenGuy.getX() && player.getPosition().getY() == greenGuy.getY()) {
			player.setPosition(new Point(3, 3));
			JOptionPane.showMessageDialog(null, "Hello, I'm green guy. Nice to meet you!", "Info: " + "Progress!",
					JOptionPane.INFORMATION_MESSAGE);
		}
		if (player.getPosition().getX() == defaultGuy.getX() && player.getPosition().getY() == defaultGuy.getY()) {
			player.setPosition(new Point(6, 8));
			JOptionPane.showMessageDialog(null, "Get out of my face, wanderer!", "Info: " + "Progress!",
					JOptionPane.INFORMATION_MESSAGE);
		}
		if (player.getPosition().getX() == playerGuy.getX() && player.getPosition().getY() == playerGuy.getY()) {
			player.setPosition(new Point(2, 7));
			JOptionPane.showMessageDialog(null, "Hmm? Do I know you from somewhere?", "Info: " + "Progress!",
					JOptionPane.INFORMATION_MESSAGE);
		}
		if (player.getPosition().getX() == sign.getX() && player.getPosition().getY() == sign.getY()) {
			player.setPosition(new Point(2, 4));
			JOptionPane.showMessageDialog(null, "Collect all 3 chests to win. Talk to other travellers along the way.",
					"Info: " + "Progress!", JOptionPane.INFORMATION_MESSAGE);
		}
		if (player.getPosition().getX() == hole.getX() && player.getPosition().getY() == hole.getY()) {
			player.setPosition(new Point(9, 3));
			JOptionPane.showMessageDialog(null, "This level is out of bounds!", "Info: " + "Work in progress...",
					JOptionPane.INFORMATION_MESSAGE);
		}
		if (c1 == true && c2 == true && c3 == true) {
			JOptionPane.showMessageDialog(null, "You have collected all 3 chests, game won.", "Info: " + "Success!",
					JOptionPane.INFORMATION_MESSAGE);
			// Exit program if game is won
			System.exit(0);
		}
	}

}
