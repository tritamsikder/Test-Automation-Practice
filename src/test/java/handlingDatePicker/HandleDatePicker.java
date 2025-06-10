package handlingDatePicker;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleDatePicker {
	
	public static void selectMonthAndYearFuture (WebDriver driver,String mon, String year, String date) {
		
		//Step 1: Month and Year Selection
		while(true) {
			String currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			if (currentMonth.equals(mon) && currentYear.equals(year)) {
				break;
			}
			driver.findElement(By.xpath("//a[@title='Next']")).click();
		}
		//Step 2: Date Selection
		List<WebElement> CalenderDate = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody/tr/td//a"));
		for (WebElement selectDate : CalenderDate) {
			if (selectDate.getText().equals(date)) {
				selectDate.click();
				break;
			}
		}
		
	}
	
	public static void selectMonthAndYearPast (WebDriver driver,String mon, String year, String date) {
		
		//Step 1: Month and Year Selection
		while(true) {
			String currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			if (currentMonth.equals(mon) && currentYear.equals(year)) {
				break;
			}
			driver.findElement(By.xpath("//a[@title='Prev']")).click();
		}
		
		//Step 2: Date Selection
		List<WebElement> CalenderDate = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody/tr/td//a"));
		for (WebElement selectDate : CalenderDate) {
			if (selectDate.getText().equals(date)) {
				selectDate.click();
				break;
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();
		
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		
//		String month = "December";
//		String year = "2028";
//		String date = "20";
		

		
		
		selectMonthAndYearFuture(driver, "December", "2028","24");
//		selectMonthAndYearPast(driver, "January", "2023","17");
		
		Thread.sleep(2000);
		driver.quit();
	}

}
