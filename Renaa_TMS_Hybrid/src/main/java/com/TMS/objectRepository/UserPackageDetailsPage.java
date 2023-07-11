/**
 * 
 */
package com.TMS.objectRepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TYSS.Renaa_TMS_Hybrid.WebActionUtility;

/**
 * @author MIRZA KASHIF BAIG
 *
 */
public class UserPackageDetailsPage {
	
	@FindBy(id = "datepicker")private WebElement fromDate;
	@FindBy(id = "datepicker1")private WebElement toDate;
	@FindBy(xpath = "//input[@name='comment']")private WebElement comment;
	@FindBy(xpath = "//button[@name='submit2']")private WebElement book;
	
	public WebActionUtility js;
	public UserPackageDetailsPage(WebDriver driver) throws IOException {
		PageFactory.initElements(driver,this);
		js=new WebActionUtility();
	}
	public WebElement getFromDate() {
		return fromDate;
	}
	public WebElement getToDate() {
		return toDate;
	}
	public WebElement getComment() {
		return comment;
	}
	public WebElement getBook() {
		return book;
	}
	public void userDetails(WebDriver driver, String fromDate, String toDate, String comment) throws Throwable {
		getFromDate().sendKeys(fromDate);
		getToDate().sendKeys(toDate);
		js.javaScriptExecuteLast(driver);
		getComment().sendKeys(comment);
		getBook().click();
	}
}
