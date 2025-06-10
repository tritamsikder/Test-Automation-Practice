package testNGParallelTest;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class NewTest {

	WebDriver driver;
  @BeforeClass
  @Parameters({"browser"})
  public void setup(String browserName) throws InterruptedException {
	  switch (browserName.toLowerCase()) {
	case "chrome": driver = new ChromeDriver();	
		break;
	case "edge": driver = new EdgeDriver();
		break;
	case "firefox":
	    WebDriverManager.firefoxdriver().setup();
	    driver = new FirefoxDriver();
	    break;

	default: System.out.println("Invalid browser");
		return;
	}	  
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	  Thread.sleep(2000);
  }
  
  @Test (priority = 1)
  public void testLogo() {
	  boolean logo = driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
	  Assert.assertEquals(logo, true);
  }
  
  @Test (priority = 2)
  public void testTitle() {
	  Assert.assertEquals(driver.getTitle(), "OrangeHRM");
  }
  
  @Test (priority = 3)
  public void testURL() {
	  Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
  }

  @AfterClass
  public void tearDown() {
	  driver.quit();
  }

}
