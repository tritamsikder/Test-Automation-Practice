package HandlingMouseActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ContextClick {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		driver.manage().window().maximize();
		
		WebElement rightClick = driver.findElement(By.xpath("//span[normalize-space()='right click me']"));
		
		Actions act = new Actions(driver);
		//right clicking on the element
		act.contextClick(rightClick).perform();
		//clicking on one option
		driver.findElement(By.xpath("//span[normalize-space()='Copy']")).click();
		//handling alert popup
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		
		
		
		Thread.sleep(2000);
		driver.quit();
	}

}
