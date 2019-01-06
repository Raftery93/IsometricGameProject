package ie.gmit.sw;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import javax.swing.Timer;
import javax.imageio.*;
import java.io.*;
import java.util.*;

/*
 * This class contains all operations in relation to the game view.
 * These operations include painting the JSwing canvas (grid, objects and sprites),
 * and switching the canvas from isometric to cartesian view (3d and 2d respectively).
 */
public class GameView extends JPanel implements ActionListener {

	private static final long serialVersionUID = 777L;

	private static GameView myInstance;

	private PlayerSprite player;
	private GreenSprite greenGuy;
	private PersonSprite person;
	private DefaultSprite defaultS;
	private ImageController img;
	private IsoViewController iso;
	private PlayerController manager;
	private boolean c1, c2, c3;
	private Timer timer; // Controls the repaint interval.

	// Models for grid and objects
	private int[][] matrix;
	private int[][] things;

	private BufferedImage[] tiles; // Note that all images, including sprites, have dimensions of 128 x 64. This
									// make painting much simpler.
	private BufferedImage[] objects; // Taller sprites can be created, by using two tiles (head torso, lower body and
										// legs) and improve animations
	private Color[] cartesian = { Color.GREEN, Color.GRAY, Color.DARK_GRAY, Color.ORANGE, Color.CYAN, Color.YELLOW,
			Color.PINK, Color.BLACK }; // This is a 2D representation

	private static boolean isIsometric = true; // Toggle between 2D and Isometric (Z key)

	public GameView() {
		super();
	}

	/**
	 * Constructor for GameView which sets the sprites, initiates the init method,
	 * and controls the timer and buffer painting the canvas.
	 * 
	 * @param matrix
	 * @param things
	 * @param player
	 * @param greenGuy
	 * @param person
	 * @param defaultS
	 * @throws Exception
	 */
	public GameView(int[][] matrix, int[][] things, PlayerSprite player, GreenSprite greenGuy, PersonSprite person,
			DefaultSprite defaultS) throws Exception {
		this.player = player;
		this.greenGuy = greenGuy;
		this.person = person;
		this.defaultS = defaultS;

		img = new ImageController();
		iso = new IsoViewController();

		init();
		this.matrix = matrix;

		this.things = things;

		setBackground(Color.WHITE);
		setDoubleBuffered(true); // Each image is buffered twice to avoid tearing / stutter

		// Intro screen
		JOptionPane.showMessageDialog(null,
				"Control the player with the Arrow keys\nMove via the 'X' button\nChange view via 'Z' button\nSee sign for more details",
				"Game Rules", JOptionPane.DEFAULT_OPTION);

		timer = new Timer(100, this); // calls the actionPerformed() method every 100ms
		timer.start(); // Start the timer
	}

	/**
	 * Creates instance of gameview
	 * 
	 * @return
	 */
	public static GameView getInstance() {
		if (myInstance == null) {
			myInstance = new GameView();
		}
		return myInstance;
	}

	/**
	 * Init method loads resources for grid
	 * 
	 * @throws Exception
	 */
	private void init() throws Exception {
		tiles = img.loadImages("./resources/images/ground", tiles);
		objects = img.loadImages("./resources/images/objects", objects);
	}

	/*
	 * Toggles view for isometric or cartesian
	 */
	public void toggleView() {
		isIsometric = !isIsometric;
		this.repaint();
	}

	/*
	 * This is called each time the timer reaches zero(non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		this.repaint();
	}

	/*
	 * Paints the grid by looping through the matrices (non-Javadoc)
	 * 
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	public void paintComponent(Graphics g) {
		// Pass graphics variable to super
		super.paintComponent(g);
		// Set graphics to 2d
		Graphics2D g2 = (Graphics2D) g;
		int imageIndex = -1, x1 = 0, y1 = 0;
		Point point;
		// Create instance of gamecontroller to begin gameplay
		GameController gc = new GameController(player);
		gc.gamePlay();
		// Inner for loop for creating grid via matrices
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[row].length; col++) {
				imageIndex = matrix[row][col];

				if (imageIndex >= 0 && imageIndex < tiles.length) {
					// Paint the ground tiles
					if (isIsometric) {
						x1 = iso.getIsoX(col, row);
						y1 = iso.getIsoY(col, row);

						g2.drawImage(tiles[Properties.getDefaultImageIndex()], x1, y1, null);
						if (imageIndex > Properties.getDefaultImageIndex()) {
							g2.drawImage(tiles[imageIndex], x1, y1, null);
						}
					} else {
						// Change to cartesian
						x1 = col * Properties.getTileWidth();
						y1 = row * Properties.getTileHeight();
						if (imageIndex < cartesian.length) {
							g2.setColor(cartesian[imageIndex]);
						} else {
							g2.setColor(Color.WHITE);
						}

						g2.fillRect(x1, y1, Properties.getTileWidth(), Properties.getTileWidth());
					}
					// Paint the object or things on the ground
					imageIndex = things[row][col];
					g2.drawImage(objects[imageIndex], x1, y1, null);
				}
			}
		}

		// Paint the player on the ground
		point = iso.getIso(player.getPosition().getX(), player.getPosition().getY());
		g2.drawImage(player.getImage(), point.getX(), point.getY(), null);

		// Paint the greenGuy on the ground
		point = iso.getIso(greenGuy.getPosition().getX(), greenGuy.getPosition().getY());
		g2.drawImage(greenGuy.getImage(), point.getX(), point.getY(), null);

		// Paint the person on the ground
		point = iso.getIso(person.getPosition().getX(), person.getPosition().getY());
		g2.drawImage(person.getImage(), point.getX(), point.getY(), null);

		// Paint the defaultGuy on the ground
		point = iso.getIso(defaultS.getPosition().getX(), defaultS.getPosition().getY());
		g2.drawImage(defaultS.getImage(), point.getX(), point.getY(), null);
	}

}