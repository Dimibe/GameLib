package javagamelib.interfaces;

/**
 * Each class which implements this Interface can perform actions every frame
 * 
 * @author dbegnis
 *
 */
public interface Updateable {

	/**
	 * this method is called each frame if the object is added to the updateables
	 * LinkedList in GameLib
	 */
	abstract void update();

}
