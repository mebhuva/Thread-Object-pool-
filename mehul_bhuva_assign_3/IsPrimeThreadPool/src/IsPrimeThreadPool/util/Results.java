package IsPrimeThreadPool.util;

import java.util.ArrayList;

import IsPrimeThreadPool.util.MyLogger.DebugLevel;

/**
 * @author Mehul
 *
 */
public class Results implements StdoutDisplayInterface{

	ArrayList<Integer> ResultList = new ArrayList<>();
	/**
	 * Default Constructor
	 */
	public Results() {
		MyLogger.writeMessage(this.getClass().getName() + "Default Constructor is called ", DebugLevel.CONSTRUCTOR);
	}


	@Override
	public void writeSumToScreen() {
		try {
			Integer sum = 0;
			for (Integer resultObject : ResultList) {
				sum += resultObject;
			}
			System.out.println(sum);
		} catch (Exception e) {
			MyLogger.writeMessage(this.getClass().getName() + " : " + e.toString(), DebugLevel.EXCEPTION);
			System.exit(0);
		} finally {

		}
	}
	
	
	@Override
	public synchronized void storeresult(int resultValue) {
		this.ResultList.add(resultValue);
	}


	@Override
	public String toString() {
		return "Results [ResultList=" + ResultList + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ResultList == null) ? 0 : ResultList.hashCode());
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
		Results other = (Results) obj;
		if (ResultList == null) {
			if (other.ResultList != null)
				return false;
		} else if (!ResultList.equals(other.ResultList))
			return false;
		return true;
	}

}
