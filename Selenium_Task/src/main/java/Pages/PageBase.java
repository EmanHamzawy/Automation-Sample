package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {

	protected WebDriver driver;
	public PageBase (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void waitForElementVisibility(WebElement element){
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForElementToBeClickable (WebElement element){
		WebDriverWait wait =new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void clickOnBtn(WebElement btn) {
		waitForElementVisibility(btn);
		waitForElementToBeClickable(btn);
		btn.click();
	}
	public void clickOnRadioBtn(WebElement btn) {
		//waitForElementVisibility(btn);
		btn.click();
	}
	public void clickOnCheckBox(WebElement btn) {
		//waitForElementVisibility(btn);
		btn.click();
	}

	public void setTextToElement(String value, WebElement element) {
		waitForElementVisibility(element);
		element.clear();
		element.sendKeys(value);
	}

	public  void selectOptionInDropdownListByValue(WebElement dropDownList , String value) {

		Select select = new Select(dropDownList);
		select.selectByValue(value);
	}

	public  void selectOptionInDropdownListByVisibleText(WebElement dropDownList , String text) {

		Select select = new Select(dropDownList);
		List<WebElement> options= dropDownList.findElements(By.tagName("option"));

		for (int i = 0 ; i<options.size() ; i++) {
			if(options.get(i).getText().contains(text)) {
				select.selectByIndex(i);
			}
		}
	}
	public void selectfromListByVisibleText(WebElement List , String text , String tagName) {
		List<WebElement> options= List.findElements(By.tagName(tagName));
		for (int i = 0 ; i<options.size() ; i++) {
			if(options.get(i).getText().equalsIgnoreCase(text)) {
				options.get(i).click();	
				break;
			}

		}
	}
	public boolean chekcInTableByVisibleText(WebElement List , String text , String tagName) {
		boolean flag = false;
		List<WebElement> options= List.findElements(By.tagName(tagName));
		for (int i = 0 ; i<options.size() ; i++) {
			if(options.get(i).getText().equals(text)) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	public void hoverListByVisibleText(WebElement List , String text , String tagName) {
		Actions action = new Actions(driver);
		List<WebElement> options= List.findElements(By.tagName(tagName));
		for (int i = 0 ; i<options.size() ; i++) {

			if(options.get(i).getText().equalsIgnoreCase(text)) 
			{
				action.moveToElement(options.get(i)).perform();
				break;
			}
		}
	}
}
