package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);
	}
	@FindBy (css = "a.login")
	WebElement signInBtn;
	
	@FindBy (xpath = "//*[@id=\"center_column\"]/p")
	public WebElement welcomeTxt;
	
	@FindBy (xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[2]")
	WebElement logOutBtn;
	
	@FindBy (xpath = "//*[@id=\"block_top_menu\"]/ul")
	WebElement categoriesList;
	
	@FindBy (xpath = "//*[@id=\"block_top_menu\"]/ul/li[1]")
	public WebElement categoryItemForAssertion;
	
	@FindBy (xpath = "//*[@id=\"block_top_menu\"]/ul/li[1]/ul")
	WebElement subCategoriesList;
	
	public void clickSignInBtn() {
		clickOnBtn(signInBtn);
	}
	public void clickLogOutBtn() {
		clickOnBtn(logOutBtn);
	}
	public void hoverOnCategory(String value) {
		hoverListByVisibleText(categoriesList, value, "a");
	}
	public void clickSubCategory(String value) {
		selectfromListByVisibleText(subCategoriesList, value, "a");
	}
	
	
	

}
