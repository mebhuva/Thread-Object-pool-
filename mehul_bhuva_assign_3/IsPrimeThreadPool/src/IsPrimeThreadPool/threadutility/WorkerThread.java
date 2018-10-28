package IsPrimeThreadPool.threadutility;

import IsPrimeThreadPool.util.FileProcessor;
import IsPrimeThreadPool.util.IsPrime;
import IsPrimeThreadPool.util.MyLogger;
import IsPrimeThreadPool.util.Results;
import IsPrimeThreadPool.util.StdoutDisplayInterface;
import IsPrimeThreadPool.util.MyLogger.DebugLevel;

/**
 * WorkerThread implements Runnable interface to create thread and override run method
 * @author Mehul
 *
 */
public class WorkerThread implements Runnable{

	//FileProcessor , IsPrime and StdoutDisplayInterface object created
	private FileProcessor fp = new FileProcessor();
	private IsPrime IsPrimeObject = new IsPrime();
	private StdoutDisplayInterface ResultsObject = new Results();
	/**
	 * setting FileProcessor , IsPrime and StdoutDisplayInterface object created
	 * @param Infp
	 * @param InisPrimeObject
	 * @param InresultsObject
	 */
	public WorkerThread(FileProcessor Infp, IsPrime InisPrimeObject, StdoutDisplayInterface InresultsObject) {
		fp = Infp;
		IsPrimeObject = InisPrimeObject;
		ResultsObject = InresultsObject;
	}
	@Override
	public void run() {
		String fileLine;
		while ( (fileLine = fp.readLine() ) != null)
        {
			boolean checkPrime = IsPrimeObject.checkIsPrime(Integer.parseInt(fileLine));
			if(checkPrime)
			{
				ResultsObject.storeresult(Integer.parseInt(fileLine));
				MyLogger.writeMessage("Run Method Called : "+ Thread.currentThread().toString() + "Running", DebugLevel.THREADRUN);
			}
			
        }
	}
	@Override
	public String toString() {
		return "WorkerThread [fp=" + fp + ", IsPrimeObject=" + IsPrimeObject + ", ResultsObject=" + ResultsObject
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
