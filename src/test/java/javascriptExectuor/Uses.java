package javascriptExectuor;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Uses {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		WebElement btn = driver.findElement(By.xpath("//input[@type='submit']"));   //perform click action
		js.executeScript("arguments[0].click();", btn);
		
		WebElement textField = driver.findElement(By.xpath("//input[@id='name']")); // sendKeys
		js.executeScript("arguments[0].value='Test';", textField);
		
		WebElement scroll = driver.findElement(By.xpath("//button[@class='dropbtn']"));  //scroll to specific element
		js.executeScript("arguments[0].scrollIntoView(true)", scroll);
		
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,300)");   //scrolling
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,-500)");
		
		Thread.sleep(2000);
		js.executeScript("window.scrollTo(0, -document.body.scrollHeight)"); //scroll to top
		
		WebElement highlight = driver.findElement(By.xpath("//h2[normalize-space()='Tabs']"));  //highlight element
		js.executeScript("arguments[0].style.border='3px solid blue'", highlight);
		
		System.out.println(js.executeScript("return document.title;")); //get page title
		
		js.executeScript("history.go(0);");
		
		Thread.sleep(2000);
		WebElement makeDisable = driver.findElement(By.xpath("//input[@id='email']"));  // making element disable
		js.executeScript("arguments[0].setAttribute('disabled','true')", makeDisable);
		
//		WebElement hiddenText = driver.findElement(By.xpath("//h2[normalize-space()='Dynamic Button']")); //find hidden text
//		System.out.println(js.executeAsyncScript("arguments[0].textContent;", hiddenText));
		
		js.executeScript("window.alert('Hello');");  //alert message
		
		driver.switchTo().alert().accept();
		
		Thread.sleep(2000);
		driver.quit();
	}

}
