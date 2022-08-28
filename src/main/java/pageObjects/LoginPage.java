package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	

	@FindBy(xpath="//input[@id='user_email']")
	WebElement emailId;
	
	
	@FindBy(xpath="//input[@id='user_password']")
	WebElement password;
	
	
	
	@FindBy(xpath="//input[@type='submit']")
	
	WebElement login;
	
	
	@FindBy(xpath="//div[contains(text(),'Invalid email or password.')]")
	WebElement loginTxt;
	
	public WebElement getEmailId() {
		return emailId;
		
	}
	
	public WebElement getPassword() {
		return password;
		
	}
	
	
	public WebElement Login() {
		return login;
		
	}
	
	
	public WebElement LoginErrorText() {
		return loginTxt;
		
	}
	
	
	
	
	

}
