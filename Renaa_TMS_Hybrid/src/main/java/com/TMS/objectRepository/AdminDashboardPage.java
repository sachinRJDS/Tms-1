/**
 * 
 */
package com.TMS.objectRepository;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

/**
 * @author MIRZA KASHIF BAIG
 *
 */
public class AdminDashboardPage {

		@FindBy(xpath = "//span[text()=' Tour Packages']")private WebElement tourPackage;
		@FindBy(xpath = "//a[text()='Create']")private WebElement create;
		@FindBy(xpath = "//a[text()='Manage']")private WebElement manage;
		@FindBy(xpath = "//span[text()='Manage Users']")private WebElement manageUsers;
		@FindBy(xpath = "//span[text()='Manage Booking']")private WebElement manageBooking;
		@FindBy(xpath = "//span[text()='Manage Issues']")private WebElement manageIssues;
		@FindBy(xpath = "//a[@class='dropdown-toggle']")private WebElement logoutDropdown;
		@FindBy(xpath = "//a[text()=' Logout']")private WebElement logout;
		@FindBy(xpath = "//h3[text()='Bookings']/../h4")private WebElement bookingCount;
		
		public AdminDashboardPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}

		public WebElement getTourPackage() {
			return tourPackage;
		}

		public WebElement getCreate() {
			return create;
		}

		public WebElement getManage() {
			return manage;
		}

		public WebElement getManageUsers() {
			return manageUsers;
		}

		public WebElement getManageBooking() {
			return manageBooking;
		}

		public WebElement getManageIssues() {
			return manageIssues;
		}

		public WebElement getLogoutDropdown() {
			return logoutDropdown;
		}

		public WebElement getLogout() {
			return logout;
		}

		public WebElement getBookingCount() {
			return bookingCount;
			}
		
		public void clickTourPackage() {getTourPackage().click();}
		public void clickCreate() {	getCreate().click();}
		public void clickManage() {	getManage().click();}
		public void clickManageBooking() {	getManageBooking().click();}
		public void clickManageIssue() {getManageIssues().click();}
		public void clickLogoutDrop() {	getLogoutDropdown().click();}
		public void clickLogout() {	getLogout().click();}
		public String clickBookingCount() {
			return getBookingCount().getText();
			}
		
		public void verifyBooking(String firstCount, String secondCount) {
			int firCount = Integer.parseInt(firstCount);
			int secCount = Integer.parseInt(secondCount);
			System.out.println("First Count is " + firstCount);
			System.out.println("Second count is " + secCount);
			
			assertTrue(firCount < secCount,"Booking is not updated");
			Reporter.log("Booking is updated",true);

		}
}
