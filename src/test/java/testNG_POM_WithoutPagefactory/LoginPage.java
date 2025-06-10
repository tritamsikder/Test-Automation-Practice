package testNG_POM_WithoutPagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;
	
	//constructor
	LoginPage(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	//locators
	By username = By.xpath("//input[@placeholder='username']");
	By password = By.xpath("//input[@placeholder='password']");
	By loginBtn = By.xpath("//button[@type='submit']");
	
	public void setUsername(String user) {
		driver.findElement(username).sendKeys(user);
	}
	
	public void setPassword(String pw) {
		driver.findElement(password).sendKeys(pw);
	}
	
	public void clickLogin() {
		driver.findElement(loginBtn).click();
	}
}
