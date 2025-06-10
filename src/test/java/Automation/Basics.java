package Automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Basics {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.webgentechnologies.us");
		driver.manage().window().maximize();
		
		//Title match
		
//		String title = driver.getTitle();
//		System.out.println(title);
//		if(title.equals("Web3 Development Company | Web3 Development Services | Webgen Technologies U")) {
//			System.out.println("Pass");
//		} else {
//			System.out.println("Fail");
//		}
		
		//locate by name locator
		
//		Thread.sleep(4000);
//		driver.findElement(By.name("Name")).sendKeys("Test");
//		
		//locate by id
//		Thread.sleep(2000);
//		System.out.println(driver.findElement(By.id("menu")).isDisplayed());
		
		//locate by linkText
//		Thread.sleep(4000);
//		driver.findElement(By.linkText("About Us")).click();
		
		//locate by partialLinkText
//		Thread.sleep(2000);
//		driver.findElement(By.partialLinkText("Reach")).click();
		
		//locate by tagName
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		//locate by className
		List<WebElement> menuCount = driver.findElements(By.className("menu"));
		System.out.println("number of menu: " + menuCount.size());
		
		List<WebElement> divCount = driver.findElements(By.tagName("div"));
		System.out.println("no. of div: " + divCount.size());
		
		int siteCount = driver.findElements(By.className("site")).size();
		System.out.println("site count: " + siteCount);
		
		Thread.sleep(10000);
		driver.quit();
		
		System.out.println(System.getProperty("user.dir"));
	}

}
