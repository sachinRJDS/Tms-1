/**
 * 
 */
package com.TMS.objectRepository;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.TYSS.Renaa_TMS_Hybrid.WebActionUtility;

/**
 * @author MIRZA KASHIF BAIG
 *
 */
public class UserHistoryPage {
	
	@FindBy(xpath = "//tbody/tr[last()]/td[9]")private WebElement cancelBtn;
	@FindBy(xpath = "//strong[text()='ERROR']")private WebElement errorMsg;
	@FindBy(xpath = "(//tbody/tr/td[7])[last()]")private WebElement confirmMsg;
	
	public WebActionUtility act;
	public WebDriver driver;
	
	public UserHistoryPage(WebDriver driver) throws IOException {
		PageFactory.initElements(driver, this);
		 act=new WebActionUtility();

	}
	public WebElement getCancelBtn() {
		return cancelBtn;
	}
	public void userHistory() {
		getCancelBtn().click();
	}
	public WebElement getErrorMsg() {
		return errorMsg;
	}
	public WebElement getConfirmMsg() {
		return confirmMsg;
	}
	
	public void userCancelClick(WebDriver driver, String error) {
		act.javaScriptExecuteLast(driver);
		getCancelBtn().click();
		try {
			driver.switchTo().alert().accept();
			act.javaScriptExecuteTop(driver);
			assertTrue(errorConfirmText().contains(error),"Cancelled ticket successfully");
			Reporter.log("User needs to wait for 24hrs to cancel the button",true);
//			if (errorConfirmText().contains(error))
//				System.out.println("User needs to wait for 24hrs to cancel the button");
		} catch (Throwable a) {
			System.out.println("Cancelled ticket successfully");
		}
	}
	public void userConfirmClick(WebDriver driver) {
		act.javaScriptExecuteLast(driver);
		getConfirmMsg().click();
	}
	public String errorConfirmText() {
		return getConfirmMsg().getText();
	}
	
	public void verifyUserConfirm(String actualConfirmMsg, String status) {
		assertTrue(actualConfirmMsg.contains(status),"User Booking is cancelled/pending");
		Reporter.log("User package is successfully booked and confirmed",true);
//		if (actualConfirmMsg.contains(status)) {
//			System.out.println("User package is successfully booked and confirmed");
//		} else
//			System.out.println("User Booking is cancelled/pending");

	}
	
}
