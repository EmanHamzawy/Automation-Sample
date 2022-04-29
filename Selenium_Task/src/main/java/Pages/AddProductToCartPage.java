package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddProductToCartPage extends PageBase{

	public AddProductToCartPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (css = "span.category-name")
	public WebElement categoryNameForAssertion;
	
	@FindBy (xpath = "//*[@id=\"center_column\"]/ul/li")
	public WebElement productsListGrid;
	
	@FindBy (xpath = "//a[@class=\"button ajax_add_to_cart_button btn btn-default\"][@title = 'Add to cart']")
	public WebElement addToCartBtn;
	
	@FindBy (xpath = "//*[@id=\"layer_cart\"]/div[1]/div[1]/h2")
	public WebElement addedSuccessfullyTxt;
	
	@FindBy (id = "layer_cart")
	public WebElement popUpLayer;
	
	@FindBy (xpath = "//a[@class= \"btn btn-default button button-medium\"][@title = 'Proceed to checkout']")
	public WebElement proceedToCheckoutBtn;
	 
	 public void hoverOnProduct(String value) {
		 hoverListByVisibleText(productsListGrid, value, "a");
	 }
	 public void clickAddToCart() {
		 clickOnBtn(addToCartBtn);
	 }
	 public void clickProceedToCheckout() {
		 clickOnBtn(proceedToCheckoutBtn);
	 }

}
