package ie.gmit.sw;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Arrays;

import javax.imageio.ImageIO;

/**
 * Class is used for controlling images by reading them in and returning the
 * images, keeps SRP.
 *
 */
public class ImageController {

	public ImageController() {
		super();
	}

	/**
	 * Takes a buffered image and loops through image.
	 * 
	 * @param directory
	 * @param img
	 * @return
	 * @throws Exception
	 */
	public static BufferedImage[] loadImages(String directory, BufferedImage[] img) throws Exception {

		File dir = new File(directory);
		File[] files = dir.listFiles();
		Arrays.sort(files, (s, t) -> s.getName().compareTo(t.getName()));

		img = new BufferedImage[files.length];
		for (int i = 0; i < files.length; i++) {
			img[i] = ImageIO.read(files[i]);
		}
		return img;
	}
}
