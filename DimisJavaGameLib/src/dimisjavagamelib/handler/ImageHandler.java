package dimisjavagamelib.handler;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

import dimisjavagamelib.exceptions.ImageNotFoundException;

/**
 * This class contains a BufferedImage Pool with all pictures so you dont load
 * Pictures twice In addition it provides some functions on BufferedImages
 * 
 * @author dbegnis
 *
 */
public class ImageHandler {

	private static HashMap<String, BufferedImage> images;

	static {
		images = new HashMap<>();
		preloadImages();
	}

	/**
	 * Returns the BufferedImage to the given String
	 * 
	 * @param img
	 *            - the FilePath or ImageName, if the Image is loaded already
	 * @return BufferedImage
	 * @throws ImageNotFoundException
	 *             - if the Image failed to laod
	 */
	public static BufferedImage getImage(String img) throws ImageNotFoundException {
		File file = new File(img);
		if (!images.containsKey(file.getName())) {
			loadImage(file);
		}
		return images.get(file.getName());
	}

	/**
	 * Returns a new BufferedImage with the given width and height
	 * 
	 * @param originalImage
	 *            - BufferedImage
	 * @param newWidth
	 *            - int
	 * @param newHeight
	 *            - int
	 * @return BufferedImage
	 */
	public static BufferedImage resizeImage(String imgName, int newWidth, int newHeight) {
		String key = new File(imgName).getName() + newWidth + "x" + newHeight;
		if (images.containsKey(key)) {
			return images.get(key);
		}
		BufferedImage originalImage = getImage(imgName);
		BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(originalImage, 0, 0, newWidth, newHeight, null);
		g.dispose();
		images.put(key, resizedImage);
		System.out.println("Added " + key + " to Images");
		return resizedImage;
	}

	/**
	 * Returns a new BufferedImage rotated in the given angle
	 * 
	 * @param img
	 *            - BufferedImage
	 * @param degrees
	 *            - double The angle how much the Image is rotated
	 * @return BufferedImage
	 */
	public static BufferedImage rotate(BufferedImage img, double degrees) {
		AffineTransform affineTransform = AffineTransform.getRotateInstance(Math.toRadians(degrees), img.getWidth() / 2,
				img.getHeight() / 2);
		BufferedImage rotatedImage = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
		Graphics2D g = (Graphics2D) rotatedImage.getGraphics();
		g.setTransform(affineTransform);
		g.drawImage(img, 0, 0, null);
		return rotatedImage;
	}

	/**
	 * Returns a new BufferedImage rotated in given angle with the given
	 * rotation point
	 * 
	 * @param img
	 *            - BufferedImage
	 * @param degrees
	 *            - double the angle
	 * @param xPos
	 *            - int the x value of the roation point
	 * @param yPos
	 *            - int the y value of the rotation point
	 * @return BufferedImage
	 */
	public static BufferedImage rotate(BufferedImage img, double degrees, int xPos, int yPos) {
		AffineTransform affineTransform = AffineTransform.getRotateInstance(Math.toRadians(degrees), xPos, yPos);
		BufferedImage rotatedImage = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
		Graphics2D g = (Graphics2D) rotatedImage.getGraphics();
		g.setTransform(affineTransform);
		g.drawImage(img, 0, 0, null);
		return rotatedImage;
	}

	private static void preloadImages() {
		File res = new File("src/dimisjavagamelib/res");
		if (!res.isDirectory() || !res.exists()) {
			System.out.println("Folder not Found");
			return;
		}
		for (File file : res.listFiles()) {
			try {
				loadImage(file);
			} catch (ImageNotFoundException e) {
				System.out.println(e.getMessage() + ": " + file.getPath());
			}
		}
	}

	private static void loadImage(File file) throws ImageNotFoundException {
		BufferedImage img = null;
		try {
			img = ImageIO.read(file);
		} catch (IOException e) {
			throw new ImageNotFoundException();
		}
		String name = file.getName();
		images.put(name, img);
		System.out.println("Added " + name + " to Images");
	}
}
