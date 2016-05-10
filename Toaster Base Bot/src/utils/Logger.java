package utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * 
 * This class is designed to log information and print the log to a text 
 * file. This class also ensures that the {@link FileNotFoundExepction} is 
 * handled in a class separately from the other classes so that if the throw
 * is triggered it will not disrupt normal operation.
 * 
 * @author Toaster Tech
 *
 */
public class Logger {
	
	private static Logger instance;
	private static long startTime;
	private static boolean fileNotFound;
	private PrintStream out = new PrintStream(new FileOutputStream("RobotLog.txt"));
	
	/**
	 * Constructor. Creates a new {@link Logger} and initializes the output
	 * stream and establishes the throw.
	 * 
	 * @throws FileNotFoundException
	 */
	public Logger() throws FileNotFoundException{
		System.setOut(out);
		fileNotFound = false;
	}
	
	/**
	 * Get the static instance of the {@link Logger}, or create a new 
	 * instance if it has not already been created. Note that a get 
	 * should be called initially to ensure construction of the 
	 * {@link Logger}
	 * 
	 * @return The static instance of the {@link SubsystemCoordinator}
	 */
	public static Logger get(){
		if(instance == null){
			try{
				instance = new Logger();
				startTime = System.currentTimeMillis();
			}catch(Exception e){
				System.out.println("EXCEPTION! FILE NOT FOUND: "+e);
				fileNotFound = true;
			}
		}
		return instance;
	}
	
	/**
	 * Adds data given in the argument to the log file. This function is
	 * used in the event that the {@code PrintStream} is not global (i.e if
	 * the {@code System.out.println} does not output to RobotLog.txt
	 * when called outside this class).
	 * 
	 * @param arg The object to be logged
	 */
	public void log(Object arg){
		if(!fileNotFound){
			if(!(instance == null)){
				System.out.println("Robot Logger: "+arg+";; Time:"+(System.currentTimeMillis() - startTime));
			}else{
				System.out.println("WARNING: INSTANCE NULL");
			}
		}else{
			System.out.println("EXCEPTION! FILE NOT FOUND: SEE ABOVE.");
		}
	}
	
}
