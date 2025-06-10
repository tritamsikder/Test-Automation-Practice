package testNG_POM_WithPagefactory;

import java.util.List;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	
	//constructor
	LoginPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this); //Mandatory
		
	}
	
	//locators	
//	@FindBy(xpath = "//input[@placeholder='username']") WebElement username;
	
	@FindBy(how = How.XPATH, using = "//input[@placeholder='username']") WebElement username; //another way to locate element
	
	@FindBy(xpath = "//input[@placeholder='password']") WebElement password;
	@FindBy(xpath = "//button[@type='submit']") WebElement loginBtn;
	
	@FindBy(tagName = "a") List<WebElement> links; //to locate multiple elements
	
	public void setUsername(String user) {
		username.sendKeys(user);
	}
	
	public void setPassword(String pw) {
		password.sendKeys(pw);
	}
	
	public void clickLogin() {
		loginBtn.click();
	}
}

