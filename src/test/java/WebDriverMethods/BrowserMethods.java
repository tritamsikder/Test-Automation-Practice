package WebDriverMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserMethods {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.opencart.com/");
		driver.findElement(By.xpath("//a[.='Start now']")).click();
		Thread.sleep(4000);
		driver.close();
		Thread.sleep(2000);
		driver.quit();
		
	}
}
