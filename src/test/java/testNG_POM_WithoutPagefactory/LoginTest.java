package testNG_POM_WithoutPagefactory;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class LoginTest {

	WebDriver driver;
	
  @BeforeClass
  public void setup() {
	  driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	  driver.manage().window().maximize();
  }

  
  @Test
  public void testLogin() {
	  LoginPage lp = new LoginPage(driver);
	  lp.setUsername("Admin");
	  lp.setPassword("admin123");
	  lp.clickLogin();
	  
	  Assert.assertEquals(driver.getTitle(), "OrangeHRM");
  }
  
  
  @AfterClass
  public void tearDown() {
	  driver.quit();
  }

}
