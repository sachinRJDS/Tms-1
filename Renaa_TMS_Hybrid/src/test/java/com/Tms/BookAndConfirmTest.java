package com.Tms;

import org.testng.annotations.Test;

import com.TMS.objectRepository.AdminCreatePage;
import com.TMS.objectRepository.AdminDashboardPage;
import com.TMS.objectRepository.AdminManageBookingPage;
import com.TMS.objectRepository.AdminSigninPage;
import com.TMS.objectRepository.HomePage;
import com.TMS.objectRepository.UserHistoryPage;
import com.TMS.objectRepository.UserHomePage;
import com.TMS.objectRepository.UserPackageDetailsPage;
import com.TMS.objectRepository.UserSignInPage;
import com.TYSS.Renaa_TMS_Hybrid.BaseClass;

public class BookAndConfirmTest extends BaseClass{
	@Test(groups = "smoke")
	public void create1() throws Throwable {

		String currentDate = jutil.currectDate();
		String toDate = jutil.toDate(7);
		String imgFile = futil.propertyFilePath("imageFile");

		String packageName = eutil.getExcelValueById(excelCommonFile, "TestData", "TC_01", "Package name");
		String packageType = eutil.getExcelValueById(excelCommonFile, "TestData", "TC_01", "Package Type");
		String packageLocation = eutil.getExcelValueById(excelCommonFile, "TestData", "TC_01", "Package Location");
		String packagePrice = eutil.getExcelValueById(excelCommonFile, "TestData", "TC_01", "Package Price in USD");
		String packageFeature = eutil.getExcelValueById(excelCommonFile, "TestData", "TC_01", "Package Features");
		String packageDetail = eutil.getExcelValueById(excelCommonFile, "TestData", "TC_01", "Package Details");
		String comments = eutil.getExcelValueById(excelCommonFile, "TestData", "TC_01", "comments ");
		String confirmMsg = eutil.getExcelValueById(excelCommonFile, "TestData", "TC_01", "Confirm msg");
		String status = eutil.getExcelValueById(excelCommonFile, "TestData", "TC_01", "status");

		HomePage home = new HomePage(driver);
		
		AdminDashboardPage adminPage = new AdminDashboardPage(driver);
		adminPage.clickTourPackage();
	
		adminPage.clickCreate();
		AdminCreatePage create = new AdminCreatePage(driver);
		create.createPackage(driver, packageName, packageType, packageLocation, packagePrice, packageFeature,
				packageDetail, imgFile);

		adminLogout();
		home.userClick();
		userLogin();
		UserHomePage userHome = new UserHomePage(driver);
		userHome.packageDetailClick(driver);
		UserPackageDetailsPage packDetail = new UserPackageDetailsPage(driver);
		packDetail.userDetails(driver, currentDate, toDate, comments);
		userLogout();
		home.adminClick();
		adminLogin();
		adminPage.clickManageBooking();
		AdminManageBookingPage manageBooking = new AdminManageBookingPage(driver);
		manageBooking.confirmClick(driver,confirmMsg);
		adminLogout();
		home.userClick();
		userLogin();
		userHome.tourHistoryClick();
		wutil.javaScriptExecuteLast(driver);

		UserHistoryPage userhistory = new UserHistoryPage(driver);
		String actualConfirmMsg = userhistory.errorConfirmText();

		userhistory.verifyUserConfirm(actualConfirmMsg,status);
		
		userHome.logoutClick();
		home.adminClick();
		adminLogin();
	}

}
