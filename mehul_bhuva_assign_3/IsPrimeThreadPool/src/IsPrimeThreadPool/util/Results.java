package IsPrimeThreadPool.util;

import java.util.ArrayList;

import IsPrimeThreadPool.util.MyLogger.DebugLevel;

public class Results {

	ArrayList<Integer> ResultList = new ArrayList<>();

	public void writeconsole() {
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
	
	public synchronized void storeresult(int resultValue) {
		this.ResultList.add(resultValue);
	}

}
