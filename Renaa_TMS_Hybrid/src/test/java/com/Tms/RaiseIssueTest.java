package com.Tms;

import java.io.IOException;
import org.testng.annotations.Test;

import com.TMS.objectRepository.AdminDashboardPage;
import com.TMS.objectRepository.AdminManageIssue;
import com.TMS.objectRepository.AdminSigninPage;
import com.TMS.objectRepository.HomePage;
import com.TMS.objectRepository.IssueTickets;
import com.TMS.objectRepository.UserHomePage;
import com.TMS.objectRepository.UserSignInPage;
import com.TMS.objectRepository.UserWriteUsPage;
import com.TYSS.Renaa_TMS_Hybrid.BaseClass;

public class RaiseIssueTest extends BaseClass {
	@Test(groups = {"smoke","regression"})
	public void create2() throws IOException {
				
		String issue = eutil.getExcelValueById(excelCommonFile,"TestData","TC_02","nagivate to SelectIssue dropdown ");
		String description = eutil.getExcelValueById(excelCommonFile,"TestData","TC_02","Enter Description");
			
		HomePage home= new HomePage(driver);
		adminLogout();
		home.userClick();
		userLogin();
		
		UserHomePage userHome=new UserHomePage(driver);
		
		userHome.writeUsClick();
		UserWriteUsPage writeUs=new UserWriteUsPage(driver);
		writeUs.createIssue(description,issue);
				
		userLogout();
		home.adminClick();
		adminLogin();
		
		AdminDashboardPage adminHome=new AdminDashboardPage(driver);
		adminHome.clickManageIssue();
		
		AdminManageIssue manageIssue=new AdminManageIssue(driver);
		String adminDesc = manageIssue.lastDescriptionText(driver);
		wutil.javaScriptExecuteTop(driver);
		adminLogout();
		home.userClick();

		userLogin();
		
		IssueTickets ticket=new IssueTickets(driver);
		userHome.issueTicketClick();
		String userTicket = ticket.lastDescText(driver);
		
		ticket.verifyIssue(adminDesc,userTicket);
		userLogout();
		home.adminClick();
		adminLogin();
		
	}

}
