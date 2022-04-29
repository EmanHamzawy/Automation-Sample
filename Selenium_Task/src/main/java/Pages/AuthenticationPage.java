package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthenticationPage extends PageBase{

	public AuthenticationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (xpath = "//*[@id=\"center_column\"]/h1")
	public WebElement authenticateTxt;
	
	@FindBy (id = "email_create")
	WebElement emailCreateTxtBox;
	
	@FindBy (id = "SubmitCreate")
	public WebElement submitCreateBtn;
	
	@FindBy (id = "email")
	WebElement emailTxtBox;
	
	@FindBy (id = "passwd")
	WebElement passwordTxtBox;
	
	@FindBy (id = "SubmitLogin")
	WebElement signInBtn;
	
	public void setEmailCreate(String value) {
		setTextToElement(value, emailCreateTxtBox);
	}
	public void clickCreateAnAccBtn() {
		clickOnBtn(submitCreateBtn);
	}
	public void setEmail(String value) {
		setTextToElement(value, emailTxtBox);
	}
	public void setPassword(String value) {
		setTextToElement(value, passwordTxtBox);
	}
	public void clickSignInBtn() {
		clickOnBtn(signInBtn);
	}
	

}
