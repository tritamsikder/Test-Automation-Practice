package keyboardAction;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
//import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class OpeningPageInNewTab {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		Actions act = new Actions(driver);
		
		//Opening register page in a new tab
		act.keyDown(Keys.CONTROL).click(driver.findElement(By.xpath("//a[@class='ico-register']"))).keyUp(Keys.CONTROL).perform();
		
		//Switching between tabs and performing action
		List<String> ids = new ArrayList<String>(driver.getWindowHandles());
//		Set<String> ids = driver.getWindowHandles();
		
		Thread.sleep(2000);
		driver.switchTo().window(ids.get(1));
		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("First Name");
		
		Thread.sleep(2000);		
		driver.switchTo().window(ids.get(0));
		driver.findElement(By.xpath("//input[@id='small-searchterms']")).sendKeys("Test");
		
		
		
		Thread.sleep(2000);
		driver.quit();
	}

}
