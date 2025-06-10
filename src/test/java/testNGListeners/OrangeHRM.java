package testNGListeners;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;


@Listeners(testNGListeners.ListenersClass.class)
public class OrangeHRM {
	
	WebDriver driver;
	
  @BeforeMethod
  public void setup() throws InterruptedException {
	  driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	  driver.manage().window().maximize();
	  Thread.sleep(2000);
  }
  
  @Test (priority = 1)
  public void testLogo() {
	  boolean logo = driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
	  Assert.assertEquals(logo, true);
  }
  
  @Test (priority = 2)
  public void testURL() {
	  Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/");
  }
  
  @Test (priority = 3, dependsOnMethods = {"testURL"})
  public void testTitle() {
	  Assert.assertEquals(driver.getTitle(), "OrangeHRM");
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
