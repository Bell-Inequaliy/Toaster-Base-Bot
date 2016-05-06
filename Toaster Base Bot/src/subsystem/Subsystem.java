package subsystem;

/**
 * 
 * This class defines three unique layers with unique parent-child relations. 
 * Parent-child definition is done through the {@link Layer} generic interface typing
 * for child layers. This class also handles all tasks for the various layers.
 *
 * @param <H> Hardware layer. Extends {@link BaseLayer}.
 * @param <S> System layer. Parents H by extension of {@link Layer} with child type H.
 * @param <C> Command layer. Parents S by extension of{@link Layer} with child type S.
 * 
 * @author Toaster Tech
 * 
 * @see Layer
 * 
 */
public class Subsystem <H extends BaseLayer, S extends Layer<H>, C extends Layer<S>> {
	
	/**
	 * As the three layers, each with their own distinct
	 * parent-child relations have been defined we need
	 * to assign them to variables for operation
	 */
	private H hardwareLayer;
	private S systemLayer;
	private C commandLayer;
	
	/**
	 * Constructor. Creates an instance of a subsystem to handle layers.
	 * 
	 * @param hardwareLayer : The target hardware layer.
	 * @param systemLayer : The target system layer.
	 * @param commandLayer : The target command layer.
	 */
	public Subsystem(H hardwareLayer, S systemLayer, C commandLayer){
		this.hardwareLayer = hardwareLayer; // Assign local variables to instances given in the constructor
		this.systemLayer = systemLayer;
		this.commandLayer = commandLayer;
		
		this.systemLayer.setChild(this.hardwareLayer); // Assign child of this instance of systemLayer
		this.commandLayer.setChild(this.systemLayer); // Assign child of this instance of commandLayer
	}

	/**
	 * Executes the {@code robotInit()} method inherited from {@link BaseLayer} for
	 * all defined layers.
	 */
	public void robotInit(){
		this.commandLayer.robotInit(); // This layer is the top layer, so initialize it first
		this.systemLayer.robotInit(); // This layer is the middle layer, so initialize it second
		this.hardwareLayer.robotInit(); // This layer is the bottom layer, so initialize it last
	}
	
	/**
	 * Executes the {@code runPeriod()} method inherited from {@link BaseLayer} for
	 * all defined layers.
	 */
	public void runPeriodic(){
		this.commandLayer.runPeriodic(); // Commands come in at the top, so run this first
		this.systemLayer.runPeriodic(); // Commands go to system next, so run this second
		this.hardwareLayer.runPeriodic(); // Hardware is the final layer executed
	}
	
	/**
	 * Sets which command layer input should be accepted from e.x:
	 * <br>
	 * <br>
	 * {@code setCommandLayer(new autonomousCommandLayer)}
	 * <br>
	 * {@code  setCommandLayer(new teleopCommandLayer)}
	 * 
	 * @param c The target command layer
	 */
	public void setCommandLayer(C c){
		commandLayer = c;
		this.commandLayer.setChild(this.systemLayer);
		this.commandLayer.robotInit();
	}
}
