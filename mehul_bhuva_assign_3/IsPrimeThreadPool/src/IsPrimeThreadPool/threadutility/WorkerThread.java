package IsPrimeThreadPool.threadutility;

import IsPrimeThreadPool.util.FileProcessor;
import IsPrimeThreadPool.util.IsPrime;
import IsPrimeThreadPool.util.MyLogger;
import IsPrimeThreadPool.util.Results;
import IsPrimeThreadPool.util.MyLogger.DebugLevel;

public class WorkerThread implements Runnable{

	private FileProcessor fp = new FileProcessor();
	private IsPrime IsPrimeObject = new IsPrime();
	private Results ResultsObject = new Results();
	public WorkerThread(FileProcessor Infp, IsPrime InisPrimeObject, Results InresultsObject) {
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

}
