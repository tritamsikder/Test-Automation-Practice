package HandlingMouseActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html#google_vignette");
		driver.manage().window().maximize();
		
		//capturing elements by xpath
		WebElement washington = driver.findElement(By.xpath("//div[@id='box3']"));
		WebElement US = driver.findElement(By.xpath("//div[@id='box103']"));
		
		Actions act = new Actions(driver);
		
		//performing drag and drop
		act.dragAndDrop(washington, US).perform();
		
		
		Thread.sleep(2000);
		driver.quit();
	}

}
