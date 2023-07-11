/**
 * 
 */
package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.TMS.objectRepository.HomePage;
import com.TMS.objectRepository.UserSignInPage;

/**
 * @author MIRZA KASHIF BAIG
 *
 */


public class DataProvider {
	@Test(dataProvider ="myData" )
	public void execute(String a, String b) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver/domain/Online_Tourism_Management_System/");
		HomePage home=new HomePage(driver);
		home.getUserSignin().click();
		UserSignInPage user=new UserSignInPage(driver);
		user.getEmail().sendKeys(a);
		user.getPassword().sendKeys(b);
		user.getSignIn().click();
		System.out.println(a+"  "+b);
		driver.quit();
		
	}

	@org.testng.annotations.DataProvider
	public Object[][] myData() throws EncryptedDocumentException, IOException{
		Object[][] obj1 = signIndata();
		return obj1;
	}
	
	
	public Object[][] signIndata() throws EncryptedDocumentException, IOException{
		FileInputStream fis=new FileInputStream("./src/test/resources/DataProvider.xlsx");
		Workbook work = WorkbookFactory.create(fis);
		Sheet sheet = work.getSheet("Sheet1");
		int rowCount = sheet.getLastRowNum();
		int cellCount = sheet.getRow(0).getLastCellNum();
		Object[][] obj=new Object[rowCount][cellCount]; 
		for (int i = 0; i <rowCount; i++) {
			for (int j = 0; j <cellCount; j++) {
				obj[i][j]=sheet.getRow(i+1).getCell(j).getStringCellValue();
				
			}
			
		}
		return obj;
	}
	
	
}
