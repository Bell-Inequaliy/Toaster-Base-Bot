package subsystem;

/**
 *
 * Additional interface for layer classes that require parenting
 * another class. Implements child-parent data flow functionality 
 * for those classes so that the extension is only done through
 * one class by the generic interface typing.
 * 
 * @author Toaster Tech
 *
 */
public interface Layer <Child extends BaseLayer> extends BaseLayer {
	/**
	 * Sets the child of this class to c
	 * 
	 * @param c : The target child class
	 */
	public void setChild(Child c);
}
