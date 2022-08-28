package Academy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;

import resources.base;
//Adding Logs
//Generating HTML Reports
//Screenshots on Failure 
//Jenkins Integration

public class ValidationNavigationBar extends base {
	
	public WebDriver driver;
	
	public  static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest

	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("Driver is initialized");
	

		/*
		 * Properties prop1 = new Properties();
		 * 
		 * FileInputStream fis2 = new FileInputStream(
		 * "C:\\Users\\JINTO\\eclipse-workspace\\E2EProject\\src\\main\\java\\resources\\data.properties"
		 * );
		 * 
		 * prop1.load(fis2);
		 */

		String URL = prop1.getProperty("url");

		driver.get(URL);
		
		log.info("Navigate to the HomePage");
		
		log.debug("It is navaigated to Home Page");
	}

	@Test
	public void NavBarValidation() throws IOException {

		LandingPage LNV = new LandingPage(driver);
		LNV.getNavTab().isDisplayed();

		String NavCheck = LNV.getNavTab().getText();

		System.out.println(NavCheck);
		
		log.info("Succesfully Navigation Bar Validated");

	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
