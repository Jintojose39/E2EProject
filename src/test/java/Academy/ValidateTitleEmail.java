package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.base;

public class ValidateTitleEmail extends base{
	
	
	public WebDriver driver;
	
	public static Logger log =LogManager.getLogger(base.class.getName());
	
	
	@BeforeTest
	
	public void Intialize() throws IOException {
		driver=initializeDriver();
		
	
		String URL = prop1.getProperty("url");

		driver.get(URL);
	
	}
	
	@Test
	
	public void ValidateAcademyTitleEmail() {
		
		
		LandingPage LNPT=new LandingPage(driver);
		
		String TitleEmail=LNPT.getAcademyEmail().getText();
		
		System.out.println(TitleEmail);
		
		Assert.assertEquals(TitleEmail,"info@qaclickacademy.com");
		
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
