package com.TYSS.Renaa_TMS_Hybrid;

import java.io.File;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerPic extends BaseClass implements ITestListener{
	public void onTestFail(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		TakesScreenshot sc=(TakesScreenshot) driver;
		File src = sc.getScreenshotAs(OutputType.FILE);
		String dateTime=LocalDateTime.now().toString().replaceAll(" ","_").replaceAll(";","_");
		File dst=new File("./Screenshot"+methodName+"_"+dateTime+".png");
		try {
			FileUtils.copyFile(src, dst);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
