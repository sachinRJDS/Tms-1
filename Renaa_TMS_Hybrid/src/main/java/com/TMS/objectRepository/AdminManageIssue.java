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
public class AdminManageIssue {
	@FindBy(xpath = "(//tbody/tr/td[6])[last()]")private WebElement lastDesc;
	
	public WebActionUtility act;
	public AdminManageIssue(WebDriver driver) throws IOException {
		PageFactory.initElements(driver,this);
		act=new WebActionUtility();
	}

	public WebElement getLastDesc() {
		return lastDesc;
	}
	
	public String lastDescriptionText(WebDriver driver){
		act.javaScriptExecuteLast(driver);
		return getLastDesc().getText();
	}
	
}
