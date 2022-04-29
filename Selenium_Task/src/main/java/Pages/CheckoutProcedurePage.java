package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutProcedurePage extends PageBase {
	public CheckoutProcedurePage(WebDriver driver) {
		super(driver);
	}
	@FindBy (xpath = "//*[@id=\"address_delivery\"]/li[3]")
	public WebElement deliveryAddressTxt;

	@FindBy (xpath = "//*[@id=\"address_delivery\"]/li[6]")
	public WebElement deliveryMobileNumTxt;

	@FindBy (xpath = "//button[@class = \"button btn btn-default button-medium\"][@name='processAddress']")
	WebElement proceedToCheckoutAddressBtn;

	@FindBy (xpath = "//*[@id=\"carrier_area\"]/h1")
	public WebElement shippingTxtForAssertion;

	@FindBy (id = "uniform-cgv")
	WebElement agreeTermsCheckBox;

	@FindBy (xpath = "//*[@id=\"uniform-cgv\"]/span")
	public WebElement agreeTermsCheckBoxForAssertion;

	@FindBy (xpath = "//button[@class = \"button btn btn-default standard-checkout button-medium\"][@name='processCarrier']")
	WebElement proceedToCheckoutShippingBtn;

	@FindBy (xpath = "//*[@id=\"center_column\"]/h1")
	public WebElement paymentTxtForAssertion;

	@FindBy (xpath = "//a[@class = \"bankwire\"][@title='Pay by bank wire']")
	WebElement bankWireOption;

	@FindBy (xpath = "//*[@id=\"center_column\"]/form/div/h3")
	public WebElement bankWirePayTxtForAssertion;

	@FindBy (xpath = "//button[@class=\"button btn btn-default button-medium\" ][ @type='submit']")
	WebElement confirmMyOrderBtn;

	@FindBy (xpath = "//*[@id=\"center_column\"]/div/p/strong")
	public WebElement orderConfirmTxt;

	@FindBy (xpath = "//*[@id=\"center_column\"]/div")
	public WebElement orderBodyDiv;

	public void clickProceedToCheckoutOnAddress() {
		clickOnBtn(proceedToCheckoutAddressBtn);
	}
	public void clickProceedToCheckoutOnShipping() {
		clickOnBtn(proceedToCheckoutShippingBtn);
	}
	public void checkAgreeTermsBox() {
		clickOnCheckBox(agreeTermsCheckBox);
	}
	public void clickBankWireOption() {
		clickOnBtn(bankWireOption);
	}
	public void clickConfirmMyOrder() {
		clickOnBtn(confirmMyOrderBtn);
	}
	public String getorderRef(String value1 , String value2) {
		String orderRef = null;
		String[] orderBodyLines = orderBodyDiv.getText().split("<br>");

		for (int i =0 ; i< orderBodyLines.length ; i++) {
			String[] line = orderBodyLines[i].split(" ");
			for (int j = 0 ; j<line.length ; j++ ) {
				if (line[j].equals(value1) && line[j+1].equals(value2)) {
					orderRef = line[j+2];
					break;
				}
			}
		}
		return orderRef;
	}
}

