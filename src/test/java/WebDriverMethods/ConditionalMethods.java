package WebDriverMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConditionalMethods {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("http://testautomationpractice.blogspot.com");
		
		Thread.sleep(2000);
		boolean maleRadioBtn = driver.findElement(By.xpath("//label[.='Male']")).isDisplayed();
		System.out.println(maleRadioBtn);
		
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("//input[@value='sunday']")).isEnabled());
		
		Thread.sleep(2000);
		WebElement maleBtn = driver.findElement(By.xpath("//input[@id='male']"));
//		maleBtn.click();
		System.out.println(maleBtn.isSelected());
		
		
		Thread.sleep(5000);
		driver.quit();
	}

}
