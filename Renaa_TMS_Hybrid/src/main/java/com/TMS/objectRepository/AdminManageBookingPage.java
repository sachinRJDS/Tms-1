/**
 * 
 */
package com.TMS.objectRepository;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;
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
public class AdminManageBookingPage {

	@FindBy(xpath = "(//tbody/tr/td[9])[last()]//a[text()='Cancel']")private WebElement cancelBtn;
	@FindBy(xpath = "(//tbody/tr/td[9])[last()]//a[text()='Confirm']")private WebElement confirmBtn;
	@FindBy(xpath = "//strong[text()='SUCCESS']")private WebElement successMsg;
	
	public WebActionUtility act;
	public AdminManageBookingPage(WebDriver driver) throws IOException {
		PageFactory.initElements(driver,this);
		act=new WebActionUtility();
	}

	public WebElement getCancelBtn() {
		return cancelBtn;
	}

	public WebElement getConfirmBtn() {
		return confirmBtn;
	}

	public WebElement getSuccessMsg() {
		return successMsg;
	}
	//Business libraries
	public void cancelClick(WebDriver driver) throws IOException {
		act.javaScriptExecuteLast(driver);
		getCancelBtn().click();
	}
	public void confirmClick(WebDriver driver,String confirmMsg) throws IOException {
		act.javaScriptExecuteLast(driver);
		getConfirmBtn().click();
		try {
		driver.switchTo().alert().accept();
		}
		catch(Throwable e) {
			e.printStackTrace();
		}
		try {
			assertTrue(confirmMsg.contains(successText()),"User Booking is not confirmed");
			Reporter.log("User Booking is confirmed",true);

		} catch (Exception e) {
		}
	}
	public String successText() {
		return getSuccessMsg().getText();
	}
}
