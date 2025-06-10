package testNGDataProvider;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class DataProviderTest {
	
	WebDriver driver;
	
  @BeforeClass
  public void setup() {
	  driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }
  
  @Test (dataProvider = "dp")
  public void testLogin(String username, String password) throws InterruptedException {
	  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	  driver.manage().window().maximize();
	  driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(username);
	  driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
	  driver.findElement(By.xpath("//button[@type='submit']")).click();
	  Thread.sleep(2000);
	  boolean logo = driver.findElement(By.xpath("//img[@alt='client brand banner']")).isDisplayed();
	  if (logo == true) {
		driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
		Assert.assertTrue(true);
	} else {
		Assert.fail();
	}
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
  
  @DataProvider (name = "dp", indices = {3,4})
  public Object[][] loginData() {
    Object data[][] = {
    		
    		{"abc","test123"},
    		{"abd","test023"},
    		{"test","test123"},
    		{"abc","test123"},
    		{"Admin","admin123"},
    		
                       };
    return data;
    }
  }



