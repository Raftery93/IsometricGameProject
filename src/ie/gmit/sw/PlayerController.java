package ie.gmit.sw;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * 
 * This class is used for controlling the player via a keylistener.
 *
 */
public class PlayerController implements KeyListener {

	private PlayerSprite player;

	/**
	 * Constructor used to obtain the player sprite.
	 * 
	 * @param player
	 */
	public PlayerController(PlayerSprite player) {
		this.player = player;
	}

	/**
	 * Method for listening for a key pressed (input).
	 */
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {// Turn right
			player.setDirection(Direction.RIGHT);
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {// Turn left
			player.setDirection(Direction.LEFT);
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {// Turn up
			player.setDirection(Direction.UP);
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {// Turn down
			player.setDirection(Direction.DOWN);
		} else if (e.getKeyCode() == KeyEvent.VK_X) {// If X is pressed, move player
			player.move();
		} else if (e.getKeyCode() == KeyEvent.VK_Z) {// If Z is pressed, change view
			GameView view = GameView.getInstance();
			view.toggleView();
		} else {
			return;
		}
	}

	public void keyReleased(KeyEvent e) {
	} // Ignore

	public void keyTyped(KeyEvent e) {
	} // Ignore
}
