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
public class UserHomePage {
	
	@FindBy(xpath = "(//a[text()='Details'])[last()]")private WebElement details;
	@FindBy(xpath = "//a[text()=' / Write Us ']")private WebElement writeUs;
	@FindBy(xpath = "//a[text()='My Tour History']")private WebElement tourHistory;
	@FindBy(xpath = "//a[text()='Issue Tickets']")private WebElement issueTicket;
	@FindBy(xpath = "//a[text()='Tour Packages']")private WebElement tourPackage;
	@FindBy(xpath = "//a[text()='/ Logout']")private WebElement logout;
	public WebActionUtility act;
	public UserHomePage(WebDriver driver) throws IOException {
		PageFactory.initElements(driver, this);
		act=new WebActionUtility();
	}
	public WebElement getDetails() {
		return details;
	}
	public WebElement getWriteUs() {
		return writeUs;
	}
	public WebElement getTourHistory() {
		return tourHistory;
	}
	public WebElement getIssueTicket() {
		return issueTicket;
	}
	public WebElement getTourPackage() {
		return tourPackage;
	}
	public WebElement getLogout() {
		return logout;
	}
	
	public void packageDetailClick(WebDriver driver) {
		act.javaScriptExecuteLast(driver);
		getDetails().click();
	}
	public void writeUsClick() {
		getWriteUs().click();
	}
	public void tourHistoryClick() {
		getTourHistory().click();
	}
	public void issueTicketClick() {
		getIssueTicket().click();
	}
	public void tourPackageClick() {
		getTourPackage().click();
	}
	public void logoutClick() {
		getLogout().click();
	}
	
	
}
