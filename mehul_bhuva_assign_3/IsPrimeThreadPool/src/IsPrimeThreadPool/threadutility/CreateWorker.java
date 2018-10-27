package IsPrimeThreadPool.threadutility;

import java.util.ArrayList;

import IsPrimeThreadPool.util.FileProcessor;
import IsPrimeThreadPool.util.IsPrime;
import IsPrimeThreadPool.util.Results;

public class CreateWorker {
	
	FileProcessor fp = new FileProcessor();
	IsPrime IsPrimeObject = new IsPrime();
    Results ResultsObject = new Results();
	public CreateWorker(FileProcessor Infp, IsPrime InisPrimeObject, Results InresultsObject) {
		fp = Infp;
		IsPrimeObject = InisPrimeObject;
		ResultsObject = InresultsObject;
	}
	
	public Results workerProcessor(int NUM_THREADS)
	{
		Results finalResult = new Results();
		ThreadPool ThreadPoolObject = new ThreadPool(NUM_THREADS);
		ArrayList<Thread> WorkerThreadList = new ArrayList<>();
		for(int i=0 ; i< NUM_THREADS ; i++)
		{
			Thread thread = new Thread(ThreadPoolObject.borrowThread(fp, IsPrimeObject, ResultsObject));
			WorkerThreadList.add(thread);
		}
		
		for(int i=0 ; i< NUM_THREADS ; i++)
		{
			WorkerThreadList.get(i).start();
		}
		
		return finalResult;
		
	}
	

}
