package Tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.CheckoutProcedurePage;
import Pages.OrderHistoryPage;

public class OrderHistoryTest extends TestBase{
	CheckoutProcedurePage checkoutObj;
	OrderHistoryPage orderHistoryObj;
	String orderRefBody;
	String orderRef;

	@Test
	public void getOrderRef() {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		checkoutObj = new CheckoutProcedurePage(driver);
		orderRef = checkoutObj.getorderRef("order","reference");
		orderHistoryObj = new OrderHistoryPage(driver);
		orderHistoryObj.clickBackToOreders();
		wait.until(ExpectedConditions.visibilityOf(orderHistoryObj.orderList));
		Assert.assertTrue(orderHistoryObj.checkOrderRefInOrderList(orderRef));
	}

}
