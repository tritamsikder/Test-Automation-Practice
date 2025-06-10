package WebDriverMethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitMethods {

public static void main(String[] args) throws InterruptedException {
// TODO Auto-generated method stub
WebDriver driver = new ChromeDriver();
driver.get("https://fishdiseaseidentifier.webgen.me/");
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //implicit wait
WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

// Thread.sleep(2000);
WebElement loginBtn = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(.,'Login')]")));
loginBtn.click();
// driver.findElement(By.xpath("//a[contains(.,'Login')]")).click();

// Thread.sleep(2000);
WebElement userName = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@name,'username')]")));
userName.sendKeys("Test");
// driver.findElement(By.xpath("//input[contains(@name,'username')]")).sendKeys("Test");

// Thread.sleep(2000);
WebElement password = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@name,'password')]")));
password.sendKeys("Test@123");
// driver.findElement(By.xpath("//input[contains(@name,'password')]")).sendKeys("Test@123");

// Thread.sleep(2000);
WebElement submitBtn = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='um-submit-btn']")));
submitBtn.click();
// driver.findElement(By.xpath("//input[@id='um-submit-btn']")).click();

// Thread.sleep(4000);
System.out.println(driver.getTitle());
System.out.println(driver.getCurrentUrl());
System.out.println(driver.getPageSource());
System.out.println(driver.getWindowHandle());

// Thread.sleep(4000);
WebElement name = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='name']")));
name.sendKeys("Test");
// driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Test");

// Thread.sleep(2000);
explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='tel']"))).sendKeys("7894561230");
// driver.findElement(By.xpath("//input[@name='tel']")).sendKeys("7894561230");

// Thread.sleep(2000);
explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='email']"))).sendKeys("test@test.com");
// driver.findElement(By.xpath("//input[@name='email']")).sendKeys("test@test.com");

// Thread.sleep(2000);
WebElement comment = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@name,'textarea-170')]")));
comment.sendKeys("This is my text query");
// driver.findElement(By.xpath("//*[contains(@name,'textarea-170')]")).sendKeys("This is my text query");

Thread.sleep(4000);
explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[.='Submit']"))).click();
// driver.findElement(By.xpath("//*[.='Submit']")).click();

// Thread.sleep(4000);
System.out.println(driver.getTitle());

// Thread.sleep(2000);
System.out.println(driver.getCurrentUrl());

// Thread.sleep(2000);
System.out.println(driver.getWindowHandle());

Thread.sleep(5000);
driver.quit();
}

}