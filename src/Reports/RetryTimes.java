package Reports;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryTimes implements IRetryAnalyzer{
	private int retryCount=0;
	private static int maxretryCount=1;
	
	@Override
	public boolean retry(ITestResult result) {
		if(retryCount<maxretryCount) {
			System.out.println("Retrying"+result.getName()+"again"+retryCount+1);
			retryCount++;
			return true;
		}
		return false;
	}

	
}
