package com.TYSS.Renaa_TMS_Hybrid;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;
import java.util.stream.IntStream;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
	
	

public class WebActionUtility {
	public FileUtility futil=new FileUtility();
	int time;
	public WebActionUtility() {
		String implicitTimePath;
		try {
			implicitTimePath = futil.propertyFilePath("commonFile");
			String timeImplicit = futil.filePathValue(implicitTimePath,"implicitTime");
			time=Integer.parseInt(timeImplicit);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void implicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));	
	}
	
	public void javaScriptExecuteLast(WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	public void javaScriptExecuteTop(WebDriver driver) {
		JavascriptExecutor je=(JavascriptExecutor) driver;
		je.executeScript("window.scrollTo(0,0)");
	}
	public void swithToAlertWindowAndConfirm(WebDriver driver, String expectedMsg) {
		Alert alt = driver.switchTo().alert();
		 if(alt.getText().equals(expectedMsg)) {
			 System.out.println("Alert Message is verified");
		 }else {
			 System.out.println("Alert Message is not verified");
		 }
		 alt.accept();
	}
	public void waitForPage(WebDriver driver , WebElement element) throws Throwable {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void select(WebElement element , String text) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}

}
