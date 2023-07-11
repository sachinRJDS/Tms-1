/**
 * 
 */
package com.TMS.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author MIRZA KASHIF BAIG
 *
 */
public class AdminSigninPage {
	//declaration
	
	@FindBy(name = "username")private WebElement userNameText;
	@FindAll({@FindBy(name = "password"), @FindBy(xpath = "//input[@type='password']")})private WebElement passwordText;
	@FindBy(xpath = "//input[@name='login']")private WebElement loginBtn;
	@FindBy(xpath = "//a[text()='Back to home']")private WebElement backToHome;
		
	//initialization
	public AdminSigninPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
		//utilization
	public WebElement getUserNameText() {
		return userNameText;
	}
	public WebElement getPasswordText() {
		return passwordText;
	}
	public WebElement getLoginBtn() {
		return loginBtn;
	}
	public WebElement getBackToHome() {
		return backToHome;
	}
	//Business library
	public void adminLogin(String userName, String password) {
		getUserNameText().sendKeys(userName);
		getPasswordText().sendKeys(password);
		getLoginBtn().click();
	}
	
	public void BackToHomeClick() {
		getBackToHome().click();
	}
	
}
