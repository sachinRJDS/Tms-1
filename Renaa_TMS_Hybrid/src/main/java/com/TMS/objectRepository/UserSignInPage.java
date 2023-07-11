/**
 * 
 */
package com.TMS.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author MIRZA KASHIF BAIG
 *
 */
public class UserSignInPage {
	
	@FindBy(xpath = "//input[@placeholder='Enter your Email']")private WebElement email;
	@FindBy(xpath = "//h3[text()='Signin with your account ']/..//input[@name='password']")private WebElement password;
	@FindBy(xpath = "//h3[text()='Signin with your account ']/..//input[@name='signin']")private WebElement signIn;
	
	public UserSignInPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getSignIn() {
		return signIn;
	}
	
	public void userSignIn(String userName, String password)
	{
		getEmail().sendKeys(userName);
		getPassword().sendKeys(password);
		getSignIn().click();
	}
	
}
