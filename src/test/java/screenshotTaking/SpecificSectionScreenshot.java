package screenshotTaking;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SpecificSectionScreenshot {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
//		TakesScreenshot ts = (TakesScreenshot) driver;
		
		WebElement el = driver.findElement(By.xpath("//div[@class='item-grid']"));
		
		File sourceFile = el.getScreenshotAs(OutputType.FILE);
		File targetFile = new File(System.getProperty("user.dir") + "\\screenshots\\page2.png");
		sourceFile.renameTo(targetFile);
		
		Thread.sleep(2000);
		driver.quit();
	}

}
