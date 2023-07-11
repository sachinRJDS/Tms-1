package com.TYSS.Renaa_TMS_Hybrid;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class ListenerRetryImpln implements IRetryAnalyzer{
	int count=0;
	int retryLimit=3;
	public boolean retry(ITestResult result) {
		if(retryLimit>count) {
			count++;
			return true;
		}
		return false;
	}
	
	
}
