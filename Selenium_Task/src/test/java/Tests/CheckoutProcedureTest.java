package Tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import DataLoader.LoadProperties;
import Pages.CheckoutProcedurePage;
import Pages.AddProductToCartPage;
import Pages.CartPage;

public class CheckoutProcedureTest extends TestBase{
	CartPage cartObj;
	CheckoutProcedurePage checkoutObj;
	AddProductToCartPage productsObj;
	
	String productName = LoadProperties.data.getProperty("ProductName");
	String cartTitleTxt = LoadProperties.data.getProperty("CartTitleTxt");
	String address = LoadProperties.data.getProperty("Address");
	String mobileNumber = LoadProperties.data.getProperty("MobileNumber");
	String shippingTxt = LoadProperties.data.getProperty("ShippingTxt");
	String paymentTxt = LoadProperties.data.getProperty("PaymentTxt");
	String bankWirePayTxt = LoadProperties.data.getProperty("BankWirePayTxt");
	String orderConfirmTxt = LoadProperties.data.getProperty("OrderConfirmTxt");
	
	@Test (priority = 1 )
	public void proceedToCheckoutFromCart() {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		productsObj = new AddProductToCartPage(driver);
		productsObj.clickProceedToCheckout();
		cartObj = new CartPage(driver);
		wait.until(ExpectedConditions.visibilityOf(cartObj.cartTitleForAssertion));
		Assert.assertTrue(cartObj.cartTitleForAssertion.getText().contains(cartTitleTxt));
		Assert.assertTrue(cartObj.ckeckTheProductInTable(productName));
	}
	@Test (priority = 2 , dependsOnMethods = "proceedToCheckoutFromCart" )
	public void NavigateToCheckout() {
		cartObj = new CartPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		cartObj.clickProceedToCheckout();
		checkoutObj = new CheckoutProcedurePage(driver);
		wait.until(ExpectedConditions.visibilityOf(checkoutObj.deliveryAddressTxt));
		Assert.assertTrue(checkoutObj.deliveryAddressTxt.getText().equalsIgnoreCase(address) && checkoutObj.deliveryMobileNumTxt.getText().equalsIgnoreCase(mobileNumber) );
	}
	@Test (priority = 3 , dependsOnMethods = "NavigateToCheckout" )
	public void ProceedCheckoutFromAddress() {
		checkoutObj = new CheckoutProcedurePage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		checkoutObj.clickProceedToCheckoutOnAddress();
		wait.until(ExpectedConditions.visibilityOf(checkoutObj.shippingTxtForAssertion));
		Assert.assertTrue(checkoutObj.shippingTxtForAssertion.getText().equalsIgnoreCase(shippingTxt));
	}
	@Test (priority = 4 , dependsOnMethods = "ProceedCheckoutFromAddress" )
	public void ProceedCheckoutFromShipping() {
		checkoutObj = new CheckoutProcedurePage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		if(checkoutObj.agreeTermsCheckBoxForAssertion.getAttribute("class")!= "checked")
			checkoutObj.checkAgreeTermsBox();
		wait.until(ExpectedConditions.attributeToBe(checkoutObj.agreeTermsCheckBoxForAssertion, "class", "checked"));
		checkoutObj.clickProceedToCheckoutOnShipping();
		wait.until(ExpectedConditions.visibilityOf(checkoutObj.paymentTxtForAssertion));
		Assert.assertTrue(checkoutObj.paymentTxtForAssertion.getText().equalsIgnoreCase(paymentTxt));
	}
	@Test (priority = 5 , dependsOnMethods = "ProceedCheckoutFromShipping" )
	public void payBankWire() {
		checkoutObj = new CheckoutProcedurePage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		checkoutObj.clickBankWireOption();
		wait.until(ExpectedConditions.visibilityOf(checkoutObj.bankWirePayTxtForAssertion));
		Assert.assertTrue(checkoutObj.bankWirePayTxtForAssertion.getText().contains(bankWirePayTxt));
	}
	@Test (priority = 6 , dependsOnMethods = "payBankWire" )
	public void cofirmMyOrder() {
		checkoutObj = new CheckoutProcedurePage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		checkoutObj.clickConfirmMyOrder();
		wait.until(ExpectedConditions.visibilityOf(checkoutObj.orderConfirmTxt));
		Assert.assertTrue(checkoutObj.orderConfirmTxt.getText().contains(orderConfirmTxt));
	}

}
