package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class MavenCommandLineTest {

	@Test
	public void test1() {
		
		WebDriver driver=null;
		String browser=System.getProperty("browser");
		String url=System.getProperty("url");
		
		if (browser.contains("chrome"))
			driver = new ChromeDriver();
		else if (browser.contains("edge"))
			driver = new EdgeDriver();
		else if (browser.contains("firefox"))
			driver = new FirefoxDriver();
		
		driver.get(url);
	}
}
