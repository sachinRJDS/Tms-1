/**
 * 
 */
package com.TYSS.Renaa_TMS_Hybrid;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.TMS.objectRepository.AdminDashboardPage;
import com.TMS.objectRepository.AdminSigninPage;
import com.TMS.objectRepository.HomePage;
import com.TMS.objectRepository.UserHomePage;
import com.TMS.objectRepository.UserSignInPage;

/**
 * @author MIRZA KASHIF BAIG
 *
 */
public class BaseClass {
	
	public WebDriver driver = null;
	public ExcelUtility eutil = new ExcelUtility();
	public FileUtility futil = new FileUtility();
	public JavaUtility jutil = new JavaUtility();
	public WebActionUtility wutil = new WebActionUtility();
	public DataBaseUtility db=new DataBaseUtility();
	public String commonFilePath;
	public String browser;
	public String url;
	public String excelCommonFile;
	public HomePage home;
	

	@BeforeSuite(groups = {"smoke","regression"})
	public void connectDB() {
		
		System.out.println("Connected to DB");
	}
	@Parameters("browser")
	@BeforeClass
	public void launchBrowser() throws Throwable  {
		
		ChromeOptions pot=new ChromeOptions();
		pot.addArguments("--disable-notifications");

		commonFilePath = futil.propertyFilePath("commonFile");
		url = System.getProperty("url", futil.filePathValue(commonFilePath, "url"));
		browser = System.getProperty("browser", futil.filePathValue(commonFilePath, "browser"));
		excelCommonFile = futil.propertyFilePath("excelFile");
		
		if (browser.contains("chrome"))
			//driver = new FirefoxDriver();
			//driver = new ChromeDriver();
			driver = new EdgeDriver();
		else if (browser.contains("edge"))
			driver = new EdgeDriver();
		else if (browser.contains("firefox"))
			driver = new FirefoxDriver();
//		else
//			driver = new ChromeDriver();

		driver.manage().window().maximize();
		wutil.implicitWait(driver);
		driver.get(url);
		System.out.println("Browser is launched and url is triggered");
	}

	@BeforeMethod(groups = {"smoke","regression"})
	public void loginToApp() throws EncryptedDocumentException, IOException {
		admin = new AdminSigninPage(driver);
		
	    home = new HomePage(driver);
		home.adminClick();
		String adminUN = System.getProperty("AdminUN", futil.filePathValue(commonFilePath, "AdminUN"));
		String adminPW = System.getProperty("AdminPW", futil.filePathValue(commonFilePath, "AdminPW"));
		admin.adminLogin(adminUN, adminPW);
		System.out.println("Before method");
	}

	@AfterMethod(groups = {"smoke","regression"})
	public void logoutFromApp() {
		AdminDashboardPage adminPage = new AdminDashboardPage(driver);
		adminPage.clickLogoutDrop();
		adminPage.clickLogout();
		admin.BackToHomeClick();
		System.out.println("After Method");
	}

	@AfterClass(groups = {"smoke","regression"})
	public void closeBrowser() {
		driver.quit();
		System.out.println("Browser is closed");
	}

	@AfterSuite(groups = {"smoke","regression"})
	public void closeDB() {
		System.out.println("Disconnected from DB");
	}
	public AdminSigninPage admin;
	public void adminLogin() throws EncryptedDocumentException, IOException {
		//home.adminClick();
		admin = new AdminSigninPage(driver);
		String adminUN = System.getProperty("AdminUN", futil.filePathValue(commonFilePath, "AdminUN"));
		String adminPW = System.getProperty("AdminPW", futil.filePathValue(commonFilePath, "AdminPW"));
		admin.adminLogin(adminUN, adminPW);
	}
	public void adminLogout() {
		AdminDashboardPage adminPage = new AdminDashboardPage(driver);
		adminPage.clickLogoutDrop();
		adminPage.clickLogout();
		admin.BackToHomeClick();
	}
	public void userLogin() throws EncryptedDocumentException, IOException {
	//	home.userClick();
		UserSignInPage userSignIn = new UserSignInPage(driver);
		String userUN = System.getProperty("UserUN", futil.filePathValue(commonFilePath, "UserUN"));
		String userPW = System.getProperty("UserPW", futil.filePathValue(commonFilePath, "UserPW"));
		userSignIn.userSignIn(userUN, userPW);
	}
	
	public void userLogout() throws IOException {
		UserHomePage user=new UserHomePage(driver);
		user.logoutClick();
	}

}
