package testcases;

import org.testng.annotations.Test;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import general.WebDriverFactory;
import objects.BaseClass;
import objects.Scenario1;
import objects.Scenario2;
import objects.Scenario3;
import objects.Scenario4;

public class AutomationTestStore extends BaseClass{
	
//	private List<WebDriver> drivers;

	
	public AutomationTestStore() throws AWTException {
		// Retrieve the list of WebDriver instances from the BaseClass
//        drivers = getDrivers();
	}

	public void test1() throws AWTException {
		List<WebDriver> drivers  = getDrivers();
            // Use each WebDriver instance to perform tests
            for (WebDriver driver : drivers) {
            	Scenario1 scenario1 = new Scenario1(driver);
    			
    			//Scenario1 TestRun
    			scenario1.SelectDove();
    			scenario1.FilterDropDown();
    			scenario1.AddToCart();
    			scenario1.VerfiyItemQuantity();
    			scenario1.VerifyPrice();
//    			driver.close();
            }
		
					
	}

	public void test12() throws AWTException {
		List<WebDriver> drivers  = getDrivers();
		System.out.println("runtest2 all driver");
		System.out.println(drivers);
		System.out.println("------------------------");
		Scenario2 scenario2;
		for (WebDriver driver : drivers) {
			System.out.println("runtest2 driver");
			System.out.println(driver);
			System.out.println("------------------------");
			scenario2= new Scenario2(driver);
			
			scenario2.SelectAppareal();
			scenario2.FilterShirts();
			scenario2.Shoes();
//			driver.quit();
		}
	}
	
	@Test
	public void test3() {
		
		for (WebDriver driver : drivers) {
		
		Scenario3 scenario3 = new Scenario3(driver);
		
		scenario3.SkinCareSale();
		scenario3.AddSaleItemToCart();
//		scenario3.CheckCart();
		driver.close();
		
	}
}

	public void test14() {

		for (WebDriver driver : drivers) {

			Scenario4 scenario4 = new Scenario4(driver);

			scenario4.MenSection();
			scenario4.VerifyTheItem();
			driver.close();
		}


	}
	
}
