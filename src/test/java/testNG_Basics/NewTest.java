package testNG_Basics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class NewTest {
	
	WebDriver driver = new ChromeDriver();
	
  @Test (priority = 1)
  public void openApp() {
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	  driver.manage().window().maximize();
  }
  
  @Test (priority = 2)
  public void checkLogo() {
	  if (driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed()) {
		System.out.println("Logo is present...");
	}
  }
  
  @Test (priority = 3)
  public void login() {
	  driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
	  driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
	  driver.findElement(By.xpath("//button[@type='submit']")).click();
  }
  
  @Test (priority = 4)
  public void logout() {
	  driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']")).click();
	  driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
  }
  
  @Test (priority = 5)
  public void closeApp() {
	  driver.quit();
  }
}
