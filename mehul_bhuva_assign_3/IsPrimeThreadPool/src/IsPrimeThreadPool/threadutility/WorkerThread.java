package IsPrimeThreadPool.threadutility;

import IsPrimeThreadPool.util.FileProcessor;
import IsPrimeThreadPool.util.IsPrime;
import IsPrimeThreadPool.util.Results;

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
		
		
	}

}
