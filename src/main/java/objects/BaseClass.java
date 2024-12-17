package objects;

import general.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import config.ConfigProperties;

public abstract class BaseClass {
	protected List<WebDriver> drivers = new ArrayList<>();

	@BeforeClass
//    @Parameters("browser")  // Pass the browser name from your test suite configuration (TestNG XML)
	public void setUp() {
		try {

			String[] browsers = ConfigProperties.Browser.split(",");

			  for (String browser : browsers) {
			  System.out.println("Setting up WebDriver using WebDriverFactory...");
			  
			  
			  // Initialize WebDriver instance based on the browser driver =
			  WebDriver driver = WebDriverFactory.getInstance(browser);
			  
			  if (driver == null) { throw new
			  IllegalStateException("Driver initialization failed. WebDriver is null."); }
			  
			  driver.manage().window().maximize();
              drivers.add(driver); // Add each driver to the list 
			  
			  }
			 

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void tearDown(WebDriver driver) {

		((WebDriverFactory) driver).finishDriver(); // Quit the driver through WebDriverFactory
		
	}

	public List<WebDriver> getDrivers() throws AWTException {
		return drivers;
	}
}
