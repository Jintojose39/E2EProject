package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	
	WebDriver driver;
	public LandingPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(xpath=" //a[@href='https://rahulshettyacademy.com/sign_in/']")
	WebElement login;
	
	
	
	@FindBy(xpath="//input[@id='user_email']")
	WebElement emailId;
	
	
	@FindBy(xpath="//input[@id='user_password']")
	WebElement password;
	
	
	
	@FindBy(xpath="//a[contains(text(),'Contact')]")
	WebElement ContactTab;
	
	
	@FindBy(xpath="//h2[contains(text(),'Featured Courses')]")
	WebElement Ftext;
	
	
	
	@FindBy(css=".navbar-collapse.collapse")
	WebElement NavTab;
	
	
	@FindBy(xpath ="//span[contains(text(),'info@qaclickacademy.com')]")
	WebElement getTitleEmail;
	
	
	
	public WebElement getLogin() {
		return login;
		
	}
	
	
	public WebElement getFtext() {
		// TODO Auto-generated method stub
		return Ftext;
	}
	public WebElement getContactTab() {
		return ContactTab;
		
	}
	
	public WebElement getNavTab() {
		return NavTab;
		
	}
	
	public WebElement getAcademyEmail() {
		return getTitleEmail;
		
	}
	
	
	
	
	
	}
	
	
	
	
	


