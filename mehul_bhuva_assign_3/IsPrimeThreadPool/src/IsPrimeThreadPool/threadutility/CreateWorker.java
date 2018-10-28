package IsPrimeThreadPool.threadutility;

import java.util.ArrayList;

import IsPrimeThreadPool.util.FileProcessor;
import IsPrimeThreadPool.util.IsPrime;
import IsPrimeThreadPool.util.MyLogger;
import IsPrimeThreadPool.util.Results;
import IsPrimeThreadPool.util.StdoutDisplayInterface;
import IsPrimeThreadPool.util.MyLogger.DebugLevel;

/**
 * @author Mehul
 *
 */
public class CreateWorker {
	
	FileProcessor fp = new FileProcessor();
	IsPrime IsPrimeObject = new IsPrime();
	StdoutDisplayInterface ResultsObject = new Results();
	/**
	 * Constructor takes 3 object and set current 3 objects
	 * @param Infp
	 * @param InisPrimeObject
	 * @param InresultsObject
	 */
	public CreateWorker(FileProcessor Infp, IsPrime InisPrimeObject, StdoutDisplayInterface InresultsObject) {
		fp = Infp;
		IsPrimeObject = InisPrimeObject;
		ResultsObject = InresultsObject;
	}
	
	/**
	 * workerProcessor borrow threads from the thread pool and perform start and join 
	 * @param NUM_THREADS
	 * @return
	 */
	public StdoutDisplayInterface workerProcessor(int NUM_THREADS)
	{
		ThreadPool ThreadPoolObject = new ThreadPool(NUM_THREADS);
		ArrayList<Thread> WorkerThreadList = new ArrayList<>();
		for(int i=0 ; i< NUM_THREADS ; i++)
		{
			try {
				ThreadPoolObject.setThreadpool(fp, IsPrimeObject, ResultsObject);
				Thread thread = new Thread(ThreadPoolObject.borrowThread());
				WorkerThreadList.add(thread);
				WorkerThreadList.get(i).start();
			} catch (Exception e) {
				MyLogger.writeMessage(this.getClass().getName() + " : " + e.toString(), DebugLevel.EXCEPTION);
				System.exit(0);
			}finally
			{
				
			}
			
		}
		
		for(int i=0 ; i< NUM_THREADS ; i++)
		{
			try {
				WorkerThreadList.get(i).join();
			} catch (InterruptedException e) {
				MyLogger.writeMessage(this.getClass().getName() + " : " + e.toString(), DebugLevel.EXCEPTION);
				System.exit(0);
			}
			finally
			{
				
			}
		}
		return ResultsObject;
		
	}

	@Override
	public String toString() {
		return "CreateWorker [fp=" + fp + ", IsPrimeObject=" + IsPrimeObject + ", ResultsObject=" + ResultsObject
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	

}
