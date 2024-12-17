package objects;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class Scenario1 {

	
	private WebDriver driver;
	//Scenario1 Objects
	By Dove = By.xpath("//a[@href='https://automationteststore.com/index.php?rt=product/manufacturer&manufacturer_id=18']");
	By dropdown = By.xpath("//select[@name='sort']");
	By Addtocart = By.xpath("//a[@data-id='76' and @class='productcart' and @title='Add to Cart']");
	By cartdropdown = By.xpath("//a[@href='https://automationteststore.com/index.php?rt=checkout/cart']");
	By ItemQuantity = By.xpath("//div[@class='input-group input-group-sm']//input[@name='quantity[76]']");
	By Price = By.xpath("(//td[@class='align_right'])[1]");
	 
	 
	public Scenario1(WebDriver driver1) {
		
		 driver = driver1;
		 System.out.println("scenario 1 running...");
		 System.out.println(driver);
		 System.out.println("------------------------");
	}
	
	//Scenario1 Functions
	
	public void SelectDove () {
		
		WebElement dove = driver.findElement(Dove);
		dove.sendKeys(Keys.PAGE_DOWN);
		driver.get("https://automationteststore.com/index.php?rt=product/manufacturer&manufacturer_id=18");
	}
	
	public void FilterDropDown() {
		
		WebElement filterDropDown = driver.findElement(dropdown);
		Select select = new Select(filterDropDown);
		select.selectByVisibleText("Date New > Old");
	}
	
	public void AddToCart() {
		
		WebElement addtocart = driver.findElement(Addtocart);
		addtocart.click();
		WebElement CartDropDown = driver.findElement(cartdropdown);
		CartDropDown.click();
		
	}
	
	public void VerfiyItemQuantity() {
	
		WebElement quantityInput = driver.findElement(ItemQuantity);
		String actualQuantity = quantityInput.getAttribute("value").trim();
	    String expectedQuantity = "1";
	    Assert.assertEquals(actualQuantity, expectedQuantity, "Quantity does not match!");
	}
	
	public void VerifyPrice() {
		
		 WebElement priceElement = driver.findElement(Price);
		 String actualPrice = priceElement.getText();
	     String expectedPrice = "$7.20";  
	     Assert.assertEquals(actualPrice, expectedPrice, "Price does not match!");
	}
	

}
