package Tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import DataLoader.LoadProperties;
import Pages.AddProductToCartPage;
import Pages.AuthenticationPage;
import Pages.HomePage;

import Pages.CartPage;

public class AddProductToCartTest extends TestBase {

	AuthenticationPage authenticateObj;
	HomePage homeObj;
	AddProductToCartPage productsObj;
	CartPage cartObj;
	
	String category = LoadProperties.data.getProperty("Category");
	String subcategory = LoadProperties.data.getProperty("Subcategory");
	String productName = LoadProperties.data.getProperty("ProductName");
	String addedSuccessfullyTxt = LoadProperties.data.getProperty("AddedSuccessfullyTxt");
	
	@Test(priority = 1)
	public void navigateToSubcategory() {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		homeObj = new HomePage(driver);
		homeObj.hoverOnCategory(category);
		wait.until(ExpectedConditions.attributeContains(homeObj.categoryItemForAssertion, "class", "sfHover"));
		homeObj.clickSubCategory(subcategory);
		productsObj = new AddProductToCartPage(driver);
		wait.until(ExpectedConditions.visibilityOf(productsObj.categoryNameForAssertion));
		Assert.assertTrue(productsObj.categoryNameForAssertion.getText().equalsIgnoreCase(subcategory));
	}
	@Test (priority = 2 , dependsOnMethods = "navigateToSubcategory")
	public void addProductToCart() {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		productsObj = new AddProductToCartPage(driver);
		productsObj.hoverOnProduct(productName);
		//wait.until(ExpectedConditions.attributeContains(ProductsObj.productsListGrid, "class", "hovered"));
		
		//System.out.println( "title -->"+ProductsObj.addToCartBtn.getAttribute("title") + "--class -->"+ProductsObj.addToCartBtn.getAttribute("class")+"--");
		
		productsObj.clickAddToCart();
		wait.until(ExpectedConditions.visibilityOf(productsObj.popUpLayer));
		Assert.assertTrue(productsObj.addedSuccessfullyTxt.getText().contains(addedSuccessfullyTxt));
	}
	//@Test (priority = 3 , dependsOnMethods = "addProductToCart")
	

}
