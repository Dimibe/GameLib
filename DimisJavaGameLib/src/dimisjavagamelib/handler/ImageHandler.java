package dimisjavagamelib.handler;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * This abstract class can be used to perform some actions on BufferdImages
 * @author dbegnis
 *
 */
public abstract class ImageHandler {
	
	public static BufferedImage loadImage(String img) {
		try {
			return ImageIO.read(ImageHandler.class.getClassLoader().getResourceAsStream(img));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static BufferedImage resizeImage(BufferedImage originalImage, int newWidth, int newHeight) {
		BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(originalImage, 0, 0, newWidth, newHeight, null);
		g.dispose();

		return resizedImage;
	}

	public static BufferedImage rotate(BufferedImage img, double degrees) {
		AffineTransform affineTransform = AffineTransform.getRotateInstance(Math.toRadians(degrees), img.getWidth() / 2,
				img.getHeight() / 2);
		BufferedImage rotatedImage = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
		Graphics2D g = (Graphics2D) rotatedImage.getGraphics();
		g.setTransform(affineTransform);
		g.drawImage(img, 0, 0, null);
		return rotatedImage;
	}

	public static BufferedImage rotate(BufferedImage img, double degrees, int xPos, int yPos) {
		AffineTransform affineTransform = AffineTransform.getRotateInstance(Math.toRadians(degrees), xPos, yPos);
		BufferedImage rotatedImage = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
		Graphics2D g = (Graphics2D) rotatedImage.getGraphics();
		g.setTransform(affineTransform);
		g.drawImage(img, 0, 0, null);
		return rotatedImage;
	}
}
