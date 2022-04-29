package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderHistoryPage extends PageBase {

	public OrderHistoryPage(WebDriver driver) {
		super(driver);
	}
	@FindBy (xpath = "//a[@class=\"button-exclusive btn btn-default\"][@title= 'Back to orders'] ")
	WebElement backToOredersBtn;
	
	@FindBy (id = "order-list")
	public WebElement orderList;
	
	public void clickBackToOreders() {
		clickOnBtn(backToOredersBtn);
	}
	public boolean checkOrderRefInOrderList(String value) {
		return chekcInTableByVisibleText(orderList, value, "a");
	}

}
