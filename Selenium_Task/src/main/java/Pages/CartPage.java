package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends PageBase {

	public CartPage(WebDriver driver) {
		super(driver);
	}
	@FindBy (id = "cart_title")
	public WebElement cartTitleForAssertion;
	
	@FindBy (id = "cart_summary")
	public WebElement cartTable;
	
	@FindBy (xpath = "//*[@id=\"product_2_7_0_680431\"]/td[2]/p/a")
	WebElement productNameForAssertion;
	
	@FindBy (xpath = "//a[@class=\"button btn btn-default standard-checkout button-medium\" ][ @title='Proceed to checkout']")
	WebElement proceedToCheckoutBtn;
	
	public boolean ckeckTheProductInTable(String value) {
		return chekcInTableByVisibleText(cartTable, value, "a");
	}
	public void clickProceedToCheckout() {
		clickOnBtn(proceedToCheckoutBtn);
	}

}
