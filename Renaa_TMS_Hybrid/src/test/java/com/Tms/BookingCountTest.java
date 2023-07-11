package com.Tms;



import org.testng.annotations.Test;

import com.TMS.objectRepository.AdminCreatePage;
import com.TMS.objectRepository.AdminDashboardPage;
import com.TMS.objectRepository.HomePage;
import com.TMS.objectRepository.UserHomePage;
import com.TMS.objectRepository.UserPackageDetailsPage;
import com.TYSS.Renaa_TMS_Hybrid.BaseClass;


public class BookingCountTest extends BaseClass {
	
	@Test(groups = "regression")
	public void create4() throws Throwable {

		String excelCommonFile = futil.propertyFilePath("excelFile");
		String currentDate = jutil.currectDate();
		String toDate = jutil.toDate(7);
		String imgFile = futil.propertyFilePath("imageFile");

		String packageName = eutil.getExcelValueById(excelCommonFile, "TestData", "TC_04", "Package name");
		String packageType = eutil.getExcelValueById(excelCommonFile, "TestData", "TC_04", "Package Type");
		String packageLocation = eutil.getExcelValueById(excelCommonFile, "TestData", "TC_04", "Package Location");
		String packagePrice = eutil.getExcelValueById(excelCommonFile, "TestData", "TC_04", "Package Price in USD");
		String packageFeature = eutil.getExcelValueById(excelCommonFile, "TestData", "TC_04", "Package Features");
		String packageDetail = eutil.getExcelValueById(excelCommonFile, "TestData", "TC_04", "Package Details");
		String comments = eutil.getExcelValueById(excelCommonFile, "TestData", "TC_04",
				"comments for booking comment section");

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

		String firstCount = adminPage.getBookingCount().getText();

		adminLogout();
		home.userClick();

		userLogin();

		userHome.packageDetailClick(driver);

		packDetail.userDetails(driver, currentDate, toDate, comments);

		userLogout();
		home.adminClick();
		adminLogin();
		String secondCount = adminPage.clickBookingCount();

	
		adminPage.verifyBooking(firstCount,secondCount);
		
	}

}
