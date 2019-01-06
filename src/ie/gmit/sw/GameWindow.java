package ie.gmit.sw;

import java.awt.*;
import java.awt.event.KeyListener;

import javax.swing.*;

public class GameWindow {
	/*
	 * This matrix represents the isometric game model, with each number mapping to
	 * an image in the images/ground/ directory.
	 */
	private int[][] model = { { 1, 0, 0, 0, 0, 0, 0, 0, 0, 2 }, { 0, 1, 0, 0, 0, 0, 0, 0, 0, 2 },
			{ 0, 0, 2, 0, 0, 0, 0, 0, 0, 2 }, { 0, 0, 0, 1, 0, 0, 0, 0, 0, 2 }, { 2, 2, 2, 2, 1, 0, 0, 0, 0, 2 },
			{ 3, 3, 3, 3, 1, 1, 1, 0, 0, 1 }, { 5, 5, 5, 5, 3, 3, 1, 0, 0, 1 }, { 4, 4, 4, 5, 3, 3, 1, 0, 0, 0 },
			{ 4, 4, 4, 4, 5, 3, 1, 6, 6, 6 }, { 4, 4, 4, 4, 4, 3, 1, 7, 7, 7 } };

	// This matrix is a representation of where objects (things) in the game are
	// placed
	private int[][] objects = { { 0, 0, 0, 5, 5, 5, 5, 5, 5, 0 }, { 5, 0, 0, 0, 5, 5, 5, 3, 5, 0 },
			{ 5, 5, 0, 0, 0, 5, 5, 5, 5, 9 }, { 5, 5, 2, 0, 0, 0, 5, 5, 5, 0 }, { 0, 0, 0, 0, 0, 0, 0, 5, 5, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 5, 0 }, { 0, 0, 0, 0, 0, 3, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 3, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };

	// Reference variables to other classes
	private PlayerSprite player;
	private GreenSprite greenGuy;
	private PersonSprite person;
	private DefaultSprite defaultS;

	/*
	 * This method is used for creating the JSwing game window. It sets the sprites
	 * values, adds the keylistener for player control, and sets the window in which
	 * the game is played.
	 */
	public GameWindow() throws Exception {

		// Setting player(knight) variables
		player = SpriteFactory.knightInstance();
		player.setName("Player 1");
		player.setPosition(new Point(0, 0));

		// Setting greenGuy variables
		greenGuy = SpriteFactory.greenGuyInstance();
		greenGuy.setName("Green guy");
		greenGuy.setPosition(new Point(3, 2));

		// Setting person variables
		person = SpriteFactory.personInstance();
		person.setName("Person");
		person.setPosition(new Point(5, 8));

		// Setting default sprite variables
		defaultS = SpriteFactory.defaultInstance();
		defaultS.setName("Default guy");
		defaultS.setPosition(new Point(1, 7));

		// Setting up the game window
		GameView view = new GameView(model, objects, player, greenGuy, person, defaultS);
		PlayerController manager = new PlayerController(player);
		Dimension d = new Dimension(Properties.getDefaultViewSize(), Properties.getDefaultViewSize() / 2);
		view.setPreferredSize(d);
		view.setMinimumSize(d);
		view.setMaximumSize(d);

		// Creating the JFrame by adding the grid and sprites. Also adding the key
		// listener
		JFrame f = new JFrame("GMIT - B.Sc. in Computing (Software Development)");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setLayout(new FlowLayout());
		f.add(view);
		f.addKeyListener(manager);
		f.setSize(1000, 1000);
		f.setLocation(100, 100);
		f.pack();
		f.setVisible(true);
	}
}