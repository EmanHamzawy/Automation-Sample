package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAnAccountPage extends PageBase {

	public CreateAnAccountPage(WebDriver driver) {
		super(driver);
	}
	@FindBy (xpath = "//*[@id=\"account-creation_form\"]/div[1]/h3")
	public WebElement yourPersonalInfoTxt;
	
	@FindBy (id = "id_gender1")
	WebElement mrRadioBtn;
	
	@FindBy (id = "id_gender2")
	WebElement mrsRadioBtn;
	
	@FindBy (id = "customer_firstname")
	WebElement firstNameTxtBox;
	
	@FindBy (id = "customer_lastname")
	WebElement lastNameTxtBox;
	
	@FindBy (id = "email")
	WebElement emailTxtBox;
	
	@FindBy (id = "passwd")
	WebElement passwordTxtBox;
	
	@FindBy (id = "days")
	WebElement daysDropDownList;
	
	@FindBy (id = "months")
	WebElement monthsDropDownList;
	
	@FindBy (id = "years")
	WebElement yearsDropDownList;
	
	@FindBy (id = "newsletter")
	WebElement signUpForNewsletterCheckBox;
	
	@FindBy (xpath = "//*[@id=\"uniform-newsletter\"]/span")
	public WebElement signUpForNewsletterToAssert;
	
	@FindBy (id = "optin")
	WebElement receiveOffersCheckBox;
	
	@FindBy (xpath = "//*[@id=\"uniform-optin\"]/span")
	public WebElement receiveOffersToAssert;
	
	@FindBy (id = "firstname")
	WebElement firstNameAddTxtBox;
	
	@FindBy (id = "lastname")
	WebElement lastNameAddTxtBox;
	
	@FindBy (id = "address1")
	WebElement addressTxtBox;
	
	@FindBy (id = "city")
	WebElement cityTxtBox;
	
	@FindBy (id = "id_state")
	WebElement stateDropDownList;
	
	@FindBy (id = "postcode")
	WebElement postCodeTxtBox;
	
	@FindBy (id = "id_country")
	WebElement countryDropDownList;
	
	@FindBy (id = "phone_mobile")
	WebElement mobileNumber;
	
	@FindBy (id = "alias")
	WebElement assignedAddTxtBox;
	
	@FindBy (id = "submitAccount")
	WebElement registerBtn;
	
	public void clickMrRadioBtn () {
		clickOnRadioBtn(mrRadioBtn);
	}
	public void clickMrsRadioBtn () {
		clickOnRadioBtn(mrsRadioBtn);
	}
	public void setCustomerFirstName(String value) {
		setTextToElement(value, firstNameTxtBox);
	}
	public void setCustomerLastName(String value) {
		setTextToElement(value, lastNameTxtBox);
	}
	public void setCustomeremail(String value) {
		setTextToElement(value, emailTxtBox);
	}
	public void setCustomerPassword(String value) {
		setTextToElement(value, passwordTxtBox);
	}
	public void selectDay(String value) {
		daysDropDownList.click();
		selectOptionInDropdownListByValue(daysDropDownList, value);
	}
	public void selectMonth(String value) {
		monthsDropDownList.click();
		selectOptionInDropdownListByVisibleText(monthsDropDownList, value);
	}
	public void selectYear(String value) {
		yearsDropDownList.click();
		selectOptionInDropdownListByVisibleText(yearsDropDownList, value);
	}
	public void checkSpecialOffersBox() {
		clickOnCheckBox(receiveOffersCheckBox);
	}
	public void checkSignUpForNewsletterBox() {
		clickOnCheckBox(signUpForNewsletterCheckBox);
	}
	public void setFirstNameAdd(String value) {
		setTextToElement(value, firstNameAddTxtBox);
	}
	public void setLastNameAdd(String value) {
		setTextToElement(value, lastNameAddTxtBox);
	}
	public void setAddress(String value) {
		setTextToElement(value, addressTxtBox);
	}
	public void setCity(String value) {
		setTextToElement(value, cityTxtBox);
	}
	public void selectState(String value) {
		stateDropDownList.click();
		selectOptionInDropdownListByVisibleText(stateDropDownList, value);
	}
	public void setPostCode(String value) {
		setTextToElement(value, postCodeTxtBox);
	}
	public void selectCountry(String value) {
		countryDropDownList.click();
		selectOptionInDropdownListByVisibleText(countryDropDownList, value);
	}
	public void setMobileNumber(String Value) {
		setTextToElement(Value, mobileNumber);
	}
	public void setAssignedAdd(String Value) {
		setTextToElement(Value, assignedAddTxtBox);
	}
	public void clickRegisterBtn() {
		clickOnBtn(registerBtn);
	}
}
