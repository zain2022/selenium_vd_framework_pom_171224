package objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Scenario3 {
	
	private WebDriver driver;
	
	//Scenario3 Objects
		By SkinCare = By.xpath("//a[@href='https://automationteststore.com/index.php?rt=product/category&path=43']");
		By InstockItems = By.xpath("//div[@class='thumbnails grid row list-inline']//div[@class='thumbnail' and .//span[@class='sale']]");
		By OutOfStock = By.xpath("//div[@class='thumbnails grid row list-inline']//div[@class='thumbnail' and .//span[@class='sale'] and .//span[@class='nostock']]");
		By SaleAddtoCart = By.xpath("//a[@class='productcart' and @title='Add to Cart']");
		By CartPrice = By.xpath("//tr[td/span[text()='Sub-Total:']]/td[2]/span");
		By GotoCart = By.xpath("//a[@href='https://automationteststore.com/index.php?rt=checkout/cart']");
		By Item2 = By.xpath("//a[@data-id='93' and contains(@class, 'productcart')]");
		By Qty1 =By.name("quantity[65]");
		By Qty2 = By.name("quantity[65]");

	public Scenario3(WebDriver driver) {
		
		this.driver = driver;
	}
	
	
	//Scenario 3 functions
	 
	 public void SkinCareSale() {
		 
		 driver.findElement(SkinCare).click();
		 List<WebElement> saleElements = driver.findElements(InstockItems);
		 List<WebElement> outofstock = driver.findElements(OutOfStock);
		 
		 System.out.println("Number of items on sale: " + saleElements.size());
	     System.out.println("Number of items out of stock: " + outofstock.size());
	 }

	 public void AddSaleItemToCart() {
		 
		 List<WebElement> saleInStockItems = driver.findElements(By.xpath("//div[@class='thumbnails grid row list-inline']//div[@class='thumbnail' and .//span[@class='sale'] and not(.//span[@class='nostock'])]"));

	     // Logging the number of items found
	     System.out.println("Number of sale items in stock: " + saleInStockItems.size());
	     
	    
	    	    // Click each "Add to Cart" button by its index
	    	    driver.findElement(SaleAddtoCart).click();	    	    	
	    	    driver.findElement(Item2).click();  	
	     
	}
	 
	 public void CheckCart() {
		 
		 driver.findElement(GotoCart).click();
		 
		// Locate the elements
		 WebElement CheckPrice = driver.findElement(CartPrice);
		 // Get the displayed text and trim any extra spaces
		 String ActualPriceText = CheckPrice.getText();
		 System.out.println("Actual Price Text (raw): " + ActualPriceText);

		 // Remove the currency symbol and other non-numeric characters from the price text
		 double totalPrice = Double.parseDouble(ActualPriceText.replace("$", "").replace(",", "").trim());
		 System.out.println("Actual Price Text (cleaned): " + totalPrice);
		 // Perform assertions
		 Assert.assertEquals(totalPrice, 309.00, "Price does not match!");
		 
		 //Assertion for Quantity
		 
		 WebElement CheckQty = driver.findElement(Qty1);
		 WebElement CheckQty1 = driver.findElement(Qty2);
		 
		 String Quantity1 = CheckQty.getAttribute("value");
		 String Quantity2 = CheckQty1.getAttribute("value");
		 
		 int ActualQuantity1 = Integer.parseInt(Quantity1);
		 int ActualQuantity2 = Integer.parseInt(Quantity2);
		 
		 int ActualQuantity = ActualQuantity1+ActualQuantity2;
		 
		 System.out.println(ActualQuantity);
		 
		 Assert.assertEquals(ActualQuantity, 2, "Quantity does not match!");
		 
	 }

}
