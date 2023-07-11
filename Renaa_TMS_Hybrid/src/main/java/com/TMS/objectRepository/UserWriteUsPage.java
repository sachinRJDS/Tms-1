/**
 * 
 */
package com.TMS.objectRepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.TYSS.Renaa_TMS_Hybrid.WebActionUtility;

/**
 * @author MIRZA KASHIF BAIG
 *
 */
public class UserWriteUsPage {
	
	@FindBy(xpath = "//select[@id='country']")private WebElement selectIssue;
	@FindBy(xpath = "//input[@name='description']")private WebElement description;
	@FindBy(xpath = "//button[@name='submit']")private WebElement submitBtn;
	
	public UserWriteUsPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public WebElement getSelectIssue() {
		return selectIssue;
	}
	public WebElement getDescription() {
		return description;
	}
	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	public void createIssue(String description, String issue) throws IOException {
		Select select= new Select(getSelectIssue());
		select.selectByVisibleText(issue);
		getDescription().sendKeys(description);
		getSubmitBtn().click();
		
	}
	
}
