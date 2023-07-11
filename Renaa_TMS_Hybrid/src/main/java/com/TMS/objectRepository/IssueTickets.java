/**
 * 
 */
package com.TMS.objectRepository;

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
public class IssueTickets {
	@FindBy(xpath = "(//tbody/tr/td[4])[last()]")private WebElement lastDescription;
	
	public WebActionUtility act;
	public IssueTickets(WebDriver driver) throws IOException {
		PageFactory.initElements(driver,this);
		act=new WebActionUtility();
	}

	public WebElement getLastDescription() {
		return lastDescription;
	}
	
	public String lastDescText(WebDriver driver) {
		act.javaScriptExecuteLast(driver);
		return getLastDescription().getText();
	}
	public void verifyIssue(String adminDesc, String userTicket) {
		assertTrue(adminDesc.equals(userTicket),"Issue is not raised successfully");
		Reporter.log("Issue is raised successfully",true);
//		if(adminDesc.equals(userTicket))
//			System.out.println("Issue is raised successfully");
//		else
//			System.out.println("Issue is not raised successfully");
	
		
	}
}
