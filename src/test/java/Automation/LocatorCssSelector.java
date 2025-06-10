package Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorCssSelector {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize(); //maximize the window
		
		//tag#id combination
//		driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("mobile");
		
		//tag is optional
//		driver.findElement(By.cssSelector("#small-searchterms")).sendKeys("Tablet");
		
		//tag.className combination
//		driver.findElement(By.cssSelector("input.search-box-text")).sendKeys("mobiles");
		
		//tag name is optional
//		driver.findElement(By.cssSelector(".search-box-text")).sendKeys("mobiles");
		
		//tag attribute
//		driver.findElement(By.cssSelector("input[name='q']")).sendKeys("Tablet");
		
		//tag name is optional
//		driver.findElement(By.cssSelector("[name='q']")).sendKeys("Tablet");
		
		//tag.className attribute combination
//		driver.findElement(By.cssSelector("input.search-box-text[name='q']")).sendKeys("Mobile");
		//tag name is optional
//		driver.findElement(By.cssSelector(".search-box-text[name='q']")).sendKeys("Mobile");
		
		
		//using selectorsHub
		driver.findElement(By.cssSelector("#small-searchterms")).sendKeys("Mobiles");
		
		
		Thread.sleep(10000);
		driver.quit();
		
		
	}

}
