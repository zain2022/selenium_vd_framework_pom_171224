package objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Scenario4 {

	WebDriver driver = null;
	
	//Scenario4 Objects
		By MenScention = By.xpath("//a[@href='https://automationteststore.com/index.php?rt=product/category&path=58']");
		By AddProduct = By.xpath("//a[@href='https://automationteststore.com/index.php?rt=product/product&path=58&product_id=78']");
		By pagecart = By.xpath("//ul[@class='productpagecart']");
		By Products =By.xpath("//a[@class='prdocutname']");
		By CartProductNmae = By.xpath("//table[@class='table table-striped table-bordered']//td[@class='align_left']//a");
		
		
	public Scenario4(WebDriver driver) {
		
		this.driver = driver;
	}

	//Scenario 4
	 
	 
	 public void MenSection(){
		 
		 WebElement mensection = driver.findElement(MenScention);
		 mensection.click();
		 
		 List<WebElement> products = driver.findElements(Products);

	     for (WebElement product : products) {
	         String productName = product.getText();

	         // Check if product name ends with 'M'
	         if (productName.endsWith("M")) {
	             System.out.println("Found product: " + productName);
	             
	             // Click on the "Product" button
	             WebElement addProduct = product.findElement(AddProduct); // Find AddProduct relative to the current product
	             addProduct.click();
	             
	             // Click on the Add to Cart Button on the page
	             WebElement cartPage = driver.findElement(pagecart);
	             cartPage.click();
	             
	             // Optionally, break the loop if you only need to add the first matching product
	             break;

	 } 
	 
	}     
	}
	 
	 public void VerifyTheItem() {
		 
		// Locate all product name elements
	        List<WebElement> productNames = driver.findElements(CartProductNmae);

	        // Iterate through product names and check for names that end with 'm'
	        for (WebElement productName : productNames) {
	            String nameText = productName.getText();
	            if (nameText.toLowerCase().endsWith("m")) {
	                System.out.println("Item ending with 'm': " + nameText);
	            }
	        }
	 }
}
