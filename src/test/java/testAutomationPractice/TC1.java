package testAutomationPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TC1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://sylvi.in/");
		
		Actions act = new Actions(driver);
		
		WebElement watchesTab = driver.findElement(By.xpath("//a[normalize-space()='WATCHES']"));
		act.moveToElement(watchesTab).build().perform();
		
		driver.findElement(By.xpath("//a[@class='site-nav__dropdown-link nav-collection'][normalize-space()='Under Rs 1000']")).click();
		
		
		Thread.sleep(2000);
		driver.quit();

	}

}
