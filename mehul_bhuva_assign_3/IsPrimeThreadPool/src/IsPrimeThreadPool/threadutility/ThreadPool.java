package IsPrimeThreadPool.threadutility;

import java.util.ArrayList;

import IsPrimeThreadPool.util.FileProcessor;
import IsPrimeThreadPool.util.IsPrime;
import IsPrimeThreadPool.util.StdoutDisplayInterface;

/**
 * @author Mehul
 *
 */
public class ThreadPool {
	 private int NUM_THREADS;
	 private ArrayList<WorkerThread> workerthreaList = new ArrayList<WorkerThread>();
	/**
	 * to initialize nUM_THREADS
	 * @param nUM_THREADS
	 */
	public ThreadPool(int nUM_THREADS) {
		this.NUM_THREADS = nUM_THREADS;
	}
	 
	/**
	 * sets the thread pool
	 * @param Infp
	 * @param InisPrimeObject
	 * @param InresultsObject
	 */
	public void setThreadpool(FileProcessor Infp, IsPrime InisPrimeObject, StdoutDisplayInterface InresultsObject)
	{
		WorkerThread workerThreadObject = new WorkerThread(Infp, InisPrimeObject, InresultsObject);
		workerthreaList.add(workerThreadObject);
		
	}
    /**
     * borrowThread borrowthread from the thread pool
     * @return workerThreadObject
     */
    public WorkerThread borrowThread()
    {
    	if(NUM_THREADS != 0)
    	NUM_THREADS--;
    	WorkerThread workerThreadObject = workerthreaList.get(0);
    	workerthreaList.remove(0);
		return workerThreadObject;
    	
    }

	@Override
	public String toString() {
		return "ThreadPool [NUM_THREADS=" + NUM_THREADS + ", workerthreaList=" + workerthreaList + ", borrowThread()="
				+ borrowThread() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + NUM_THREADS;
		result = prime * result + ((workerthreaList == null) ? 0 : workerthreaList.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ThreadPool other = (ThreadPool) obj;
		if (NUM_THREADS != other.NUM_THREADS)
			return false;
		if (workerthreaList == null) {
			if (other.workerthreaList != null)
				return false;
		} else if (!workerthreaList.equals(other.workerthreaList))
			return false;
		return true;
	}
	
}
