package ie.gmit.sw;

/**
 * 
 * This class is used for running the program. It contains the main method,
 * along with code that runs the GUI by instantiating the GameWindow class.
 *
 */
public class Runner {
	/**
	 * Main method
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		// Runs the GUI. Code is asynchronous (Not good).
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() { // Template method
				try {
					// Instantiate Gamewindow
					new GameWindow();
				} catch (Exception e) {
					e.printStackTrace();// Need to deal with the better
				}
			}
		});
	}
}