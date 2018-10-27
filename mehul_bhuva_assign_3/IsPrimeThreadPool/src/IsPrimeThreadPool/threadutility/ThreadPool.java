package IsPrimeThreadPool.threadutility;

import IsPrimeThreadPool.util.FileProcessor;
import IsPrimeThreadPool.util.IsPrime;
import IsPrimeThreadPool.util.Results;

public class ThreadPool {
	 private int NUM_THREADS;
	public ThreadPool(int nUM_THREADS) {
		this.NUM_THREADS = nUM_THREADS;
	}
	 
    public WorkerThread borrowThread(FileProcessor Infp, IsPrime InisPrimeObject, Results InresultsObject)
    {
    	if(NUM_THREADS != 0)
    	NUM_THREADS--;
    	WorkerThread workerThreadObject = new WorkerThread(Infp, InisPrimeObject, InresultsObject);
		return workerThreadObject;
    	
    }
}
