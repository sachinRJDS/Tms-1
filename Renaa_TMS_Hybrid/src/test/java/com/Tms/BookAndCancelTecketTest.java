package com.Tms;

import org.testng.annotations.Test;

import com.TMS.objectRepository.AdminCreatePage;
import com.TMS.objectRepository.AdminDashboardPage;
import com.TMS.objectRepository.HomePage;
import com.TMS.objectRepository.UserHistoryPage;
import com.TMS.objectRepository.UserHomePage;
import com.TMS.objectRepository.UserPackageDetailsPage;
import com.TYSS.Renaa_TMS_Hybrid.BaseClass;


public class BookAndCancelTecketTest extends BaseClass{
	
	@Test(groups = {"smoke","regression"})
	public void create3() throws Throwable {

		String imgFile = futil.propertyFilePath("imageFile");
		String currentDate = jutil.currectDate();
		String toDate = jutil.toDate(7);

		String packageName = eutil.getExcelValueById(excelCommonFile, "TestData", "TC_03", "Package name");
		String packageType = eutil.getExcelValueById(excelCommonFile, "TestData", "TC_03", "Package Type");
		String packageLocation = eutil.getExcelValueById(excelCommonFile, "TestData", "TC_03", "Package Location");
		String packagePrice = eutil.getExcelValueById(excelCommonFile, "TestData", "TC_03", "Package Price in USD");
		String packageFeature = eutil.getExcelValueById(excelCommonFile, "TestData", "TC_03", "Package Features");
		String packageDetail = eutil.getExcelValueById(excelCommonFile, "TestData", "TC_03", "Package Details");
		String comments = eutil.getExcelValueById(excelCommonFile, "TestData", "TC_03", "comments ");
		String errorMsg = eutil.getExcelValueById(excelCommonFile, "TestData", "TC_03", "Error ");

	
		
		AdminDashboardPage adminPage = new AdminDashboardPage(driver);
		adminPage.clickTourPackage();
		adminPage.clickCreate();
		
		AdminCreatePage create = new AdminCreatePage(driver);
		create.createPackage(driver,packageName, packageType, packageLocation, packagePrice, packageFeature,packageDetail, imgFile);
		
		adminLogout();
		
		home.userClick();
		userLogin();

		UserHomePage userHome=new UserHomePage(driver);
		userHome.packageDetailClick(driver);

		UserPackageDetailsPage packDetail = new UserPackageDetailsPage(driver);
		packDetail.userDetails(driver,currentDate, toDate, comments);

		userHome.tourHistoryClick();
		UserHistoryPage userhistory = new UserHistoryPage(driver);
		userhistory.userCancelClick(driver,errorMsg);
		userHome.logoutClick();
		home.adminClick();
		adminLogin();
	}

}
