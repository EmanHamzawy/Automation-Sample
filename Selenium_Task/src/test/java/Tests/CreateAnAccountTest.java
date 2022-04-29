package Tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import DataLoader.LoadProperties;
import Pages.AuthenticationPage;
import Pages.CreateAnAccountPage;
import Pages.HomePage;

public class CreateAnAccountTest extends TestBase {
	
	HomePage homeObject;
	AuthenticationPage authenticateObj;
	CreateAnAccountPage createAnAccountObj;
	
	/// for Assertion 
	String authTxt = LoadProperties.data.getProperty("AuthenticateTxt");
	String yourPersonalInfoTxt = LoadProperties.data.getProperty("YourPersonalInfoTxt");
	String welcomeToMyAccountTxt = LoadProperties.data.getProperty("WelcomeToMyAccountTxt");
	
	/// user data
	String email =rand3Numbers + LoadProperties.data.getProperty("Email");
	String title = LoadProperties.data.getProperty("Title");
	String firstName = LoadProperties.data.getProperty("FirstName");
	String lastName = LoadProperties.data.getProperty("LastName");
	String password = LoadProperties.data.getProperty("Password");
	String day = LoadProperties.data.getProperty("Day");
	String month = LoadProperties.data.getProperty("Month");
	String year = LoadProperties.data.getProperty("year");
	String signupNewsLetter = LoadProperties.data.getProperty("SignupNewsLetter");
	String receiveSpecialOffers = LoadProperties.data.getProperty("ReceiveSpecialOffers");
	
	// Address Data
	String address = LoadProperties.data.getProperty("Address");
	String city = LoadProperties.data.getProperty("Address");
	String state = LoadProperties.data.getProperty("State");
	String postCode = LoadProperties.data.getProperty("PostCode");
	String country = LoadProperties.data.getProperty("Country");
	String mobileNumber = LoadProperties.data.getProperty("MobileNumber");
	String assignedAddress = LoadProperties.data.getProperty("AssignAddress");
	

	@Test (priority = 1)
	public void NavigateToAuthPage() {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		homeObject = new HomePage(driver);
		homeObject.clickSignInBtn();
		authenticateObj = new AuthenticationPage(driver);
		wait.until(ExpectedConditions.visibilityOf(authenticateObj.authenticateTxt));
		
		Assert.assertTrue(authenticateObj.authenticateTxt.getText().equalsIgnoreCase(authTxt));
	}
	
	@Test (priority = 2, dependsOnMethods = "NavigateToAuthPage")
	public void setMailAdd() {
		WebDriverWait wait = new WebDriverWait(driver, 70);
		authenticateObj = new AuthenticationPage(driver);
		authenticateObj.setEmailCreate(email);
		authenticateObj.clickCreateAnAccBtn();
		createAnAccountObj = new CreateAnAccountPage(driver);
		wait.until(ExpectedConditions.visibilityOf(createAnAccountObj.yourPersonalInfoTxt));
		
		Assert.assertTrue(createAnAccountObj.yourPersonalInfoTxt.getText().equalsIgnoreCase(yourPersonalInfoTxt));
	}
	@Test (priority = 3, dependsOnMethods = "setMailAdd" )
	public void Registration () {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		SoftAssert softAssertion= new SoftAssert();
		createAnAccountObj = new CreateAnAccountPage(driver);
		// Personal Info
		if (title.equalsIgnoreCase("Mr"))
			createAnAccountObj.clickMrRadioBtn();
		else if (title.equalsIgnoreCase("Mrs"))
			createAnAccountObj.clickMrsRadioBtn();
		createAnAccountObj.setCustomerFirstName(firstName);
		createAnAccountObj.setCustomerLastName(lastName);
		createAnAccountObj.setCustomeremail(email);
		createAnAccountObj.setCustomerPassword(password);
		createAnAccountObj.selectDay(day);
		createAnAccountObj.selectMonth(month);
		createAnAccountObj.selectYear(year);
		
		if (signupNewsLetter.equalsIgnoreCase("true")) {
			createAnAccountObj.checkSignUpForNewsletterBox();
			softAssertion.assertTrue(createAnAccountObj.signUpForNewsletterToAssert.getAttribute("class").equalsIgnoreCase("checked"));
		}
		if (receiveSpecialOffers.equalsIgnoreCase("true")) {
			createAnAccountObj.checkSpecialOffersBox();
			softAssertion.assertTrue(createAnAccountObj.receiveOffersToAssert.getAttribute("class").equalsIgnoreCase("checked"));
		}
		
		// Set Address Data
		createAnAccountObj.setFirstNameAdd(firstName);
		createAnAccountObj.setLastNameAdd(lastName);
		createAnAccountObj.setAddress(address);
		createAnAccountObj.setCity(city);
		createAnAccountObj.selectState(state);
		createAnAccountObj.setPostCode(postCode);
		createAnAccountObj.selectCountry(country);
		createAnAccountObj.setMobileNumber(mobileNumber);
		createAnAccountObj.setAssignedAdd(assignedAddress);
		createAnAccountObj.clickRegisterBtn();
		softAssertion.assertAll();
		homeObject = new HomePage(driver);
		wait.until(ExpectedConditions.visibilityOf(homeObject.welcomeTxt));
		Assert.assertTrue(homeObject.welcomeTxt.getText().contains(welcomeToMyAccountTxt));
	}
	
	@Test (priority = 4, dependsOnMethods = "Registration" )
	public void logOut() {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		homeObject = new HomePage(driver);
		homeObject.clickLogOutBtn();
		authenticateObj = new AuthenticationPage(driver);
		wait.until(ExpectedConditions.visibilityOf(authenticateObj.authenticateTxt));
		
		Assert.assertTrue(authenticateObj.authenticateTxt.getText().equalsIgnoreCase(authTxt));
	}
	

}
