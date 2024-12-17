package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Scenario2 {
	
	private WebDriver driver;
	
	//Scenario2 Objects
		WebElement cartIcon;
		By Filter = By.cssSelector("select#sort");
		By CartIconShirt = By.cssSelector("i.fa.fa-cart-plus.fa-fw");
		By size = By.cssSelector("select#option351");
		By CartIcon = By.cssSelector("ul.productpagecart");
		By Shoe = By.cssSelector("a[href='https://automationteststore.com/index.php?rt=product/product&path=68_69&product_id=115']");
		By Shoe1 = By.cssSelector("a[href='https://automationteststore.com/index.php?rt=product/product&path=68_69&product_id=117']");

		public Scenario2(WebDriver driver) {
			
			this.driver = driver;
			System.out.println("scenario 2 running...");
			System.out.println(driver);
			System.out.println("------------------------");
		}
		
		
		//Scenario2 Functions
		
		public void SelectAppareal() {
			
			 System.out.println("Appareal function");
			 System.out.println(driver);
			 System.out.println("------------------------");
			driver.findElement(By.cssSelector("a[href='https://automationteststore.com/index.php?rt=product/category&path=68']")).click();
			driver.findElement(By.cssSelector("a[href='https://automationteststore.com/index.php?rt=product/category&path=68_70']")).click();
		}
		
		public void FilterShirts() {
			 System.out.println("Filter function");
			 System.out.println(driver);
			 System.out.println("------------------------");
			
			WebElement sortDropdown= driver.findElement(Filter);
			Select select = new Select(sortDropdown);
	        select.selectByVisibleText("Rating Lowest");
	        
	        //Clicking the shirt to the cart
	        WebElement cartIconshirt = driver.findElement(CartIconShirt);
	        cartIconshirt.click();
	        
	        //selecting the size
	        WebElement Size = driver.findElement(size);
	        Select selectsize = new Select(Size);
	        selectsize.selectByVisibleText("Medium");
	        
	        //Add to cart
	        cartIcon = driver.findElement(CartIcon);
	        cartIcon.click();
	        
		}
		
	 public void Shoes() {
		 
		 driver.findElement(By.cssSelector("a[href='https://automationteststore.com/index.php?rt=product/category&path=68']")).click();
		 System.out.println("Shoes function");
		 System.out.println(driver);
		 System.out.println("------------------------");
		 driver.findElement(By.cssSelector("a[href='https://automationteststore.com/index.php?rt=product/category&path=68_69']")).click();
		 
		 //select the shoes
		 driver.findElement(Shoe).click();
		 cartIcon = driver.findElement(CartIcon);
	     cartIcon.click();
	     driver.navigate().to("https://automationteststore.com/index.php?rt=product/category&path=68_69");
	     driver.findElement(Shoe1).click();
	     cartIcon = driver.findElement(CartIcon);
	     cartIcon.click();
	     
	 }

}
