package IsPrimeThreadPool.util;

import IsPrimeThreadPool.util.MyLogger.DebugLevel;

public class IsPrime {

	public boolean checkIsPrime(int Number)
	{
		try {
			if (Number % 2 == 0)
			{
				return false;
			}	
			 else
			 {
				 return true;
			 }
		} catch (Exception e) {
			MyLogger.writeMessage(this.getClass().getName() + " : " + e.toString(), DebugLevel.EXCEPTION);
			System.exit(0);
		}
		return false;
	}
}
