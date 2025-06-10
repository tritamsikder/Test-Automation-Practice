package HandleingIframes;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IframeHandle {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://ui.vision/demo/webtest/frames/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Switch to frame1
		WebElement frame1 = driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Test1");
		driver.switchTo().defaultContent();
		
		//Switch to frame2
		WebElement frame2 = driver.findElement(By.xpath("//frame[@src='frame_2.html']"));
		driver.switchTo().frame(frame2);
		driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("Test2");
		driver.switchTo().defaultContent();
		
		//Switch to frame3
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement frame3 = driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
		driver.switchTo().frame(frame3);
		driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("Test3");
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//label[@for='i12']//div[@class='bzfPab wFGF8']")).click();
		WebElement radioInput = wait.until(ExpectedConditions.elementToBeClickable(
			    By.xpath("//input[@aria-label='Other response']")));
		radioInput.sendKeys("Test");
//		driver.findElement(By.xpath("//input[@aria-label='Other response']")).sendKeys("Test3");
		List<WebElement> checkBox = driver.findElements(By.xpath("//div[@class='uHMk6b fsHoPb']"));
		for (WebElement checkbox : checkBox) {
			checkbox.click();
		}
		driver.switchTo().defaultContent();
		
		//Switch to frame4
		WebElement frame4 = driver.findElement(By.xpath("//frame[@src='frame_4.html']"));
		driver.switchTo().frame(frame4);
		driver.findElement(By.xpath("//input[@name='mytext4']")).sendKeys("Test4");
		driver.switchTo().defaultContent();
		
		
		Thread.sleep(5000);
		driver.quit();
	}

}
