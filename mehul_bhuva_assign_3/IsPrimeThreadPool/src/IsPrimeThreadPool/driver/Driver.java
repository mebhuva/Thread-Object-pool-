package IsPrimeThreadPool.driver;

import IsPrimeThreadPool.threadutility.CreateWorker;
import IsPrimeThreadPool.util.FileProcessor;
import IsPrimeThreadPool.util.IsPrime;
import IsPrimeThreadPool.util.MyLogger;
import IsPrimeThreadPool.util.Results;

public class Driver {

	/**
	 * Main method is the entry point of this project
	 * @param args
	 */
	public static void main(String[] args) {

		/*
		 * As the build.xml specifies the arguments as argX, in case the argument value
		 * is not given java takes the default value specified in build.xml. To avoid
		 * that, below condition is used
		 */
		if (args.length != 3 || args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}")) {

			System.err.println("Invalid arguments specified");
            System.err.println("Command : ant -buildfile build.xml run -Darg0=input.txt -Darg1=NUM_THREADS -Darg2=DEBUG_LEVEL");
            System.err.println("DEBUG_LEVEL : 0 - None, 1 - RESULTCONTENT, 2 - RESULTCONTENTUPDATED, 3 - THREADRUN, 4 - CONSTRUCTOR , 5 : EXCEPTION");
            System.exit(0);
		} else {
			FileProcessor fp = new FileProcessor(args);
			int checkinsert = fp.fileInputExists();// checking if insert file exists or not in the directory
			if (checkinsert == 0) {
				System.err.println("Insert File not found");
				System.exit(0);
			}
			if (! isInteger(args[1]))
			{
				System.err.println("NUM_THREADS Value shuld be a number");
	            System.err.println("DEBUG_LEVEL : 0 - None, 1 - RESULTCONTENT, 2 - RESULTCONTENTUPDATED, 3 - THREADRUN, 4 - CONSTRUCTOR , 5 : EXCEPTION");
	            System.exit(0);
			}
			if (! isInteger(args[2]))
			{
				System.err.println("Debug Value shuld be a number");
	            System.err.println("DEBUG_LEVEL : 0 - None, 1 - RESULTCONTENT, 2 - RESULTCONTENTUPDATED, 3 - THREADRUN, 4 - CONSTRUCTOR , 5 : EXCEPTION");
	            System.exit(0);
			}
			else
			{
				int debug_level = Integer.parseInt(args[2]);
	            if ( debug_level < 0 || debug_level > 5 )
	            {
	                System.err.println("Debug level should be between 0 and 3");
	                System.err.println("DEBUG_LEVEL : 0 - None, 1 - File Porcessor, 2 - Constructor, 3 - Results, 4 - Error , 5 - Debug");
	                System.exit(0);
	            }
	            MyLogger.setDebugValue(debug_level);
	            IsPrime IsPrimeObject = new IsPrime();
	            Results ResultsObject = new Results();
	            CreateWorker CreateWorkerObject = new CreateWorker(fp,IsPrimeObject,ResultsObject);
	            ResultsObject = CreateWorkerObject.workerProcessor(Integer.parseInt(args[1]));
	            ResultsObject.writeconsole();
	            
			}
			
			
			
			
		}
		
		
		}
	private static boolean isInteger( String str )
    {
        try
        {
            int i = Integer.parseInt(str);
            return true;
        }
        catch( NumberFormatException er)
        {
            return false;
        }
    }
	
	
}
