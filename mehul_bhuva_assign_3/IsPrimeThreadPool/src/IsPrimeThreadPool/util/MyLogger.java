package IsPrimeThreadPool.util;

/**
 * MyLogger gives debug level
 * @author Mehul
 *
 */
public class MyLogger {
	// FIXME: Add more enum values as needed for the assignment
	public static enum DebugLevel {
		CONSTRUCTOR, RESULTCONTENT , NONE , EXCEPTION , RESULTCONTENTUPDATED , THREADRUN
	};

	private static DebugLevel debugLevel;

	// FIXME: Add switch cases for all the levels
	/**
	 * setDebugValue sets debug level
	 * @param levelIn
	 */
	public static void setDebugValue(int levelIn) {
		switch (levelIn) {
		case 5:
            debugLevel = DebugLevel.EXCEPTION;
            break;
        case 4:
            debugLevel = DebugLevel.CONSTRUCTOR; 
            break;
		case 3:
			debugLevel = DebugLevel.THREADRUN;
			break;
		case 2:
			debugLevel = DebugLevel.RESULTCONTENTUPDATED;
			break;
		case 1:
			debugLevel = DebugLevel.RESULTCONTENT;
			break;
		default:
			debugLevel = DebugLevel.NONE;
			break;
		}
	}

	/**
	 * set current debug level
	 * @param levelIn
	 */
	public static void setDebugValue(DebugLevel levelIn) {
		debugLevel = levelIn;
	}

	/**
	 * To display message
	 * @param message
	 * @param levelIn
	 */
	public static void writeMessage(String message, DebugLevel levelIn) {
		if (levelIn == debugLevel)
			System.out.println(message);
	}

	public String toString() {
		return "The debug level has been set to the following " + debugLevel;
	}
}
