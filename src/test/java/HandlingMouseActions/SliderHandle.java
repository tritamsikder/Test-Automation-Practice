package HandlingMouseActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderHandle {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		driver.manage().window().maximize();
		
		WebElement firstSlider = driver.findElement(By.xpath("//span[@tabindex='0'][1]"));
		WebElement secondSlider = driver.findElement(By.xpath("//span[@tabindex='0'][2]"));
		
		System.out.println("First Slider Position: " + firstSlider.getLocation());
		System.out.println("Second slider position is: " + secondSlider.getLocation());
		
		Actions act = new Actions(driver);
		
		act.dragAndDropBy(firstSlider, 100, 250).perform(); //we can give the Y axis 0 as well or the current position
		act.dragAndDropBy(firstSlider, 150, 250).perform();
		act.dragAndDropBy(firstSlider, -100, 250).perform();
		System.out.println("First Slider Position after moving it: " + firstSlider.getLocation());
		
		act.dragAndDropBy(secondSlider, -100, 250).perform();
		act.dragAndDropBy(secondSlider, -150, 250).perform();
		act.dragAndDropBy(secondSlider, 150, 250).perform();
		System.out.println("Second Slider Position after moving it: " + secondSlider.getLocation());
		
		
		Thread.sleep(2000);
		driver.quit();
	}

}
