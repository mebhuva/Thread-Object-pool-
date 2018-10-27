package IsPrimeThreadPool.util;

import java.util.ArrayList;

import IsPrimeThreadPool.util.MyLogger.DebugLevel;

public class Results {

	ArrayList<Integer> ResultList = new ArrayList<>();

	public void writeconsole() {
		// TODO Auto-generated method stub
		try {
			for (Integer resultObject : ResultList) {
				System.out.println(resultObject);
			}
		} catch (Exception e) {
			MyLogger.writeMessage(this.getClass().getName() + " : " + e.toString(), DebugLevel.EXCEPTION);
			System.exit(0);
		} finally {

		}
	}

}
