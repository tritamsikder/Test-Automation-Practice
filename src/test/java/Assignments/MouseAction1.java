package assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MouseAction1 {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		//Double click
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement field1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='field1']")));
		WebElement field2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='field2']")));
		WebElement btn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Copy Text']")));
		
		Actions act = new Actions(driver);
		
		Action doubleClk = act.doubleClick(btn).build();
		doubleClk.perform();
		
		if (field1.getAttribute("value").equals(field2.getAttribute("value"))) {
			System.out.println("pass");
		} else {
			System.out.println("fail");
		}
		
		//drag and drop
		WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement drop = driver.findElement(By.xpath("//div[@id='droppable']"));
		
		Action dragDrop = act.dragAndDrop(drag, drop).build();
		dragDrop.perform();
		
		Thread.sleep(2000);
		driver.quit();
		
	}

}
