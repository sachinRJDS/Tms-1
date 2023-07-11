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
public class HomePage {
	
	@FindBy(xpath = "//a[text()='Admin Login']")private WebElement adminSigninBtn;
	@FindBy(xpath = "//a[text()='/ Sign In']")private WebElement userSignin;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		
	}

	public WebElement getAdminSigninBtn() {
		return adminSigninBtn;
	}

	public WebElement getUserSignin() {
		return userSignin;
	}
	
	public void adminClick() {
		getAdminSigninBtn().click();
	}
	public void userClick() {
		getUserSignin().click();
	}
	
}
