package dimisjavagamelib.exceptions;

public class ImageNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ImageNotFoundException() {
		super("ImageNotFound");
	}
	
	public ImageNotFoundException(String errorMessage) {
		super(errorMessage);
	}
}
