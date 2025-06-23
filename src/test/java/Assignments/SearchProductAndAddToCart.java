package assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SearchProductAndAddToCart {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://sylvi.in/");
		
		Actions act = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		driver.findElement(By.xpath("//*[name()='path' and contains(@d,'M24.9428 8')]")).click();
		
		WebElement watchesOption = driver.findElement(By.xpath("//a[normalize-space()='WATCHES']"));
		act.moveToElement(watchesOption).build().perform();
		
		WebElement under2000 = driver.findElement(By.xpath("//a[@class='site-nav__dropdown-link nav-collection'][normalize-space()='Under Rs 2000']"));
		under2000.click();
		
		WebElement proTimerClassyBlue = driver.findElement(By.xpath("//div[normalize-space()='ProTimer Classy Blue']"));	
		js.executeScript("arguments[0].scrollIntoView();", proTimerClassyBlue);
		Thread.sleep(2000);
		
		act.moveToElement(proTimerClassyBlue);
		Thread.sleep(1000);
		
		WebElement addToCartBtn = driver.findElement(By.xpath("//div[@data-product-handle='classy-blue-dial-sports-wrist-watch-for-men']//span[@data-default-text='Add to cart'][normalize-space()='Add to cart']"));
		act.moveToElement(addToCartBtn).build().perform();
		Thread.sleep(1000);
		addToCartBtn.click();
		
		driver.findElement(By.xpath("//form[@id='CartDrawerForm']//div[@class='drawer__fixed-header']//button[@type='button']//*[name()='svg']")).click();
		
		driver.findElement(By.xpath("//span[@class='cart-link']//*[name()='svg']")).click();
		
		Thread.sleep(2000);
		WebElement confirmOrder = driver.findElement(By.xpath("//p[normalize-space()='Confirm Order']"));
		js.executeScript("arguments[0].click();", confirmOrder);
		js.executeScript("arguments[0].click();", confirmOrder);
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[@class='snap_powered_merchant_name white_label_comany_name']")).click();
		
		
		
		Thread.sleep(2000);
		driver.quit();
	}

}
