package Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorXpath {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.opencart.com/");
		driver.manage().window().maximize();
		
		//Xpath using single attribute
//		System.out.println(driver.findElement(By.xpath("//div[@class='hero-button-description text-center']")).isDisplayed());
		
		
		
		//Xpath using multiple attribute
//		driver.findElement(By.xpath("//a[@target='_blank'][@class='btn btn-success btn-xl']")).click();
		//another way
//		driver.findElement(By.xpath("//a[@target='_blank' and @class='btn btn-success btn-xl']")).click();
		
		
		//Xpath with text()
//		driver.findElement(By.xpath("//a[text()='Start now']")).click();
		//we can use . as text()
//		driver.findElement(By.xpath("//a[.='Start now']")).click();
		
		
		//Xpath with contains()    --> using text()
//		driver.findElement(By.xpath("//a[contains(text(),'Start')]")).click();
		
		//Xpath with contains()    --> using attribute
//		driver.findElement(By.xpath("//a[contains(@class,'btn btn-success btn-xl')]")).click();
		
		
		//Xpath with starts-with()   -->using text()
//		driver.findElement(By.xpath("//a[starts-with(text(),'Star')]")).click();
//		driver.findElement(By.xpath("//a[starts-with(.,'Star')]")).click();
		
		//Xpath with starts-with()   -->using attribute
//		driver.findElement(By.xpath("//a[starts-with(@class,'btn btn-succe')]")).click();
		
		
		//chained Xpath
//		driver.findElement(By.xpath("//div[@class='navbar-header']/a/img")).click();
		
		
		
		
		Thread.sleep(10000);
		driver.quit();
	}

}
