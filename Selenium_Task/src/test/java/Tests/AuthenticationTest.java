package Tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import DataLoader.LoadProperties;
import Pages.AuthenticationPage;
import Pages.HomePage;

public class AuthenticationTest extends TestBase{
	HomePage homeObject;
	AuthenticationPage authenticateObj;

	/// for Assertion 
		String authTxt = LoadProperties.data.getProperty("AuthenticateTxt");
		String welcomeToMyAccountTxt = LoadProperties.data.getProperty("WelcomeToMyAccountTxt");
		
	/// for login	
	String email =rand3Numbers + LoadProperties.data.getProperty("Email");
	String password = LoadProperties.data.getProperty("Password");
	@Test (priority = 1)
	public void NavigateToAuthPage() {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		homeObject = new HomePage(driver);
		homeObject.clickSignInBtn();
		authenticateObj = new AuthenticationPage(driver);
		wait.until(ExpectedConditions.visibilityOf(authenticateObj.authenticateTxt));
		Assert.assertTrue(authenticateObj.authenticateTxt.getText().equalsIgnoreCase(authTxt));
	}
	
	@Test(priority = 2 , dependsOnMethods = "NavigateToAuthPage")
	public void AuthenticateAsNewUser() {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		authenticateObj = new AuthenticationPage(driver);
		authenticateObj.setEmail(email);
		authenticateObj.setPassword(password);
		authenticateObj.clickSignInBtn();
		homeObject = new HomePage(driver);
		wait.until(ExpectedConditions.visibilityOf(homeObject.welcomeTxt));
		Assert.assertTrue(homeObject.welcomeTxt.getText().contains(welcomeToMyAccountTxt));
	}
}
