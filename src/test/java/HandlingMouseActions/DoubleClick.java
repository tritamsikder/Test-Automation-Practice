package HandlingMouseActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleClick {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");
		driver.manage().window().maximize();
		
		//switch to frame
		driver.switchTo().frame("iframeResult");
		
		//storing xpath of elements
		WebElement field1 = driver.findElement(By.xpath("//input[@id='field1']"));
		WebElement field2 = driver.findElement(By.xpath("//input[@id='field2']"));
		WebElement btn = driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));
			
		Actions act = new Actions(driver);
		
		//clearing field1 and writing something
		field1.clear();
		field1.sendKeys("DoubleClick");
		
		act.doubleClick(btn).build().perform();
		
		if (field1.getAttribute("value").equals(field2.getAttribute("value"))) {
//		if (field1.getAttribute("value").equals("DoubleCick")) {
			System.out.println("pass");
		} else {
			System.out.println("fail");
		}
		
		
		
		Thread.sleep(2000);
		driver.quit();
	}

}
