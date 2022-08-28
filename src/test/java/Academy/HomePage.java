package Academy;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base {
	
	public WebDriver driver;
	
	public  static Logger log = LogManager.getLogger(base.class.getName());

	// public Properties prop1;
	
	@BeforeTest
	public void SetBrowser() throws IOException {
		driver = initializeDriver();

		/*
		 * prop1 = new Properties();
		 * 
		 * FileInputStream fis2 = new FileInputStream(
		 * "C:\\Users\\JINTO\\eclipse-workspace\\E2EProject\\src\\main\\java\\resources\\data.properties"
		 * );
		 * 
		 * prop1.load(fis2);
		 */

		
	}
	
	

	@Test(dataProvider = "getData")

	public void basePageNavigation(String emailId, String passWord) throws IOException  {

		String URL = prop1.getProperty("url");

		driver.get(URL);
		/*
		 * prop1 = new Properties();
		 * 
		 * FileInputStream fis2 = new FileInputStream(
		 * "C:\\Users\\JINTO\\eclipse-workspace\\E2EProject\\src\\main\\java\\resources\\data.properties"
		 * );
		 * 
		 * prop1.load(fis2);
		 */

		log.info("Driver Launched");
		//T=Title Email
		
	
		
		LandingPage LNP = new LandingPage(driver);
		String FText = LNP.getFtext().getText();

		System.out.println(FText);
		// here we validate text is present or not

		Assert.assertEquals(FText, "FEATURED COURSES");

		boolean check = LNP.getContactTab().isDisplayed();

		// here we validate Contact tab is present or not

		String NavTab = LNP.getNavTab().getText();

		boolean NavCheck = LNP.getNavTab().isDisplayed();

		Assert.assertTrue(NavCheck);

		System.out.println(NavTab);
		log.info("Navigation Bar Dispalyed");

		Assert.assertTrue(check);

		System.out.println(check);

		log.info("Log Clicked");
		
		
		LNP.getLogin().click();

		LoginPage LP = new LoginPage(driver);

		/*
		 * Properties prop2 = new Properties();
		 * 
		 * FileInputStream fis3 = new FileInputStream(
		 * "C:\\Users\\JINTO\\eclipse-workspace\\E2EProject\\src\\main\\java\\resources\\data.properties"
		 * );
		 * 
		 * prop2.load(fis3);
		 * 
		 * String Email = prop2.getProperty("email");
		 * 
		 * String Password = prop2.getProperty("password");
		 * 
		 * /*LP.getEmailId().sendKeys(Email); LP.getPassword().sendKeys(Password);
		 * LP.Login().click();
		 */

		LP.getEmailId().sendKeys(emailId);
		LP.getPassword().sendKeys(passWord);
		
		LP.Login().click();
		
		log.info("Login button is clicked");
		
	}
	
		/*String LoginError=LP.LoginErrorText().getText();
		
		System.out.println(LoginError);
		
		
		Assert.assertEquals(LoginError,"Invalid email or password.");*/
		@AfterTest
		public void tearDown() {
			driver.close();	
		}
		
	

		
	

	@DataProvider
	public Object[][] getData() {

		Object[][] data = new Object[2][2];

		// 0 row and first coloumn

		// First

		data[0][0] = "nonrestricteduser@gmail.com";
		// 0 row and second coloumn
		data[0][1] = "Jintojose1996";

		// 0 user and 2 Coloumn

		data[1][0] = "jinto98@gmail.com";
		data[1][1] = "jinto789";

		return data;

	}

}
