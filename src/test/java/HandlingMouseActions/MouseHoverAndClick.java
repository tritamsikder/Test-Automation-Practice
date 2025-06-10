package HandlingMouseActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class MouseHoverAndClick {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.webgentechnologies.com/");
		driver.manage().window().maximize();
//		Thread.sleep(10000);
		
		WebElement Industries = driver.findElement(By.xpath("//span[normalize-space()='Industries']"));
		WebElement Automotive = driver.findElement(By.xpath("//span[normalize-space()='Automotive']"));
		
		Actions act = new Actions(driver);
		act.moveToElement(Industries).build().perform();
		act.moveToElement(Automotive).click().build().perform(); //important (hover then click)
	
		
		Thread.sleep(4000);
		driver.quit();
	}

}
