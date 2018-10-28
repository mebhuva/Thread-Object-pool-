package IsPrimeThreadPool.util;

import IsPrimeThreadPool.util.MyLogger.DebugLevel;

/**
 * IsPrime class have function checkIsPrime to check if number is prime or not
 * @author Mehul
 *
 */
public class IsPrime {

	/**
	 * Default Constructor
	 * 
	 */
	public IsPrime() {
		MyLogger.writeMessage(this.getClass().getName() + "Default Constructor is called ", DebugLevel.CONSTRUCTOR);
	}

	/**
	 * checkIsPrime check if number is prime or not
	 * @param Number
	 * @return true or false based on condition
	 */
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
		}finally {
			
		}
		
		return false;
	}

	@Override
	public String toString() {
		return "IsPrime [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
}
