package Tests;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;

import DataLoader.LoadProperties;
import Utilities.Helper;

public class TestBase {
	String URL = LoadProperties.data.getProperty("URL");
	static String rand3Numbers = Helper.getRandomNumber();
	public static WebDriver driver;
	@BeforeTest
	public void startDriver (@Optional("chrome")String browsername) {

		if(browsername.equalsIgnoreCase("chrome"))
		{
			String chromepath=System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver",chromepath) ;
			driver = new ChromeDriver();
		}
		// in else section add another browsers
		driver.manage().window().setSize(new Dimension(1024,768));
		driver.get(URL);
	}
	@AfterMethod
	public void ScreenshotOnFailure(ITestResult result)
	{
		if (result.getStatus() == ITestResult.FAILURE) {
			System.out.println("Failed!");
			System.out.println("Taking Screenshot .....");
			Helper.CaptureScreenshot(driver, result.getName());			
		}
	}
	@AfterTest
	public void tearDown() {
		//driver.quit();
	}

}
