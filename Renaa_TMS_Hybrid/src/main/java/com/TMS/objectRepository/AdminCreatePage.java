/**
 * 
 */
package com.TMS.objectRepository;

import java.io.File;
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

public class AdminCreatePage {
	@FindBy(id = "packagename")private WebElement packageName;
	@FindBy(id = "packagetype")private WebElement packageType;
	@FindBy(id = "packagelocation")private WebElement packageLocation;
	@FindBy(id = "packageprice")private WebElement packagePrice;
	@FindBy(id="packagefeatures")private WebElement packageFeatures;
	@FindBy(id = "packagedetails")private WebElement packageDetails;
	@FindBy(id = "packageimage")private WebElement packageImage;
	@FindBy(name = "submit")private WebElement submit;
	
	public WebActionUtility wutil;
	public AdminCreatePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		wutil=new WebActionUtility();
	}
	public WebElement getPackageName() {
		return packageName;
	}
	public WebElement getPackageType() {
		return packageType;
	}
	public WebElement getPackageLocation() {
		return packageLocation;
	}
	public WebElement getPackagePrice() {
		return packagePrice;
	}
	public WebElement getPackageFeatures() {
		return packageFeatures;
	}
	public WebElement getPackageDetails() {
		return packageDetails;
	}
	public WebElement getPackageImage() {
		return packageImage;
	}
	public WebElement getSubmit() {
		return submit;
	}
	//business library
	public void createPackage(WebDriver driver, String packagename, String packagetype, String packageloc, String packagePrice,String packageFeature, String packageDetail, String packageImage ) throws IOException {
		getPackageName().sendKeys(packagename);
		getPackageType().sendKeys(packagetype);
		getPackageLocation().sendKeys(packageloc);
		getPackagePrice().sendKeys(packagePrice);
		getPackageFeatures().sendKeys(packageFeature);
		getPackageDetails().sendKeys(packageDetail);
		wutil.javaScriptExecuteLast(driver);
		File img=new File(packageImage);
		String f = img.getAbsolutePath();
		getPackageImage().sendKeys(f);
		getSubmit().click();
	}
}
