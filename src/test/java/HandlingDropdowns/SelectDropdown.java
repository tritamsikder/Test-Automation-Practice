package HandlingDropdowns;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		//select from drop down
		WebElement dropdown = driver.findElement(By.xpath("//select[@id='country']"));
		Select CountryDrop = new Select(dropdown);
		
		CountryDrop.selectByIndex(1);
		Thread.sleep(2000);
		CountryDrop.selectByValue("australia");
		Thread.sleep(2000);
		CountryDrop.selectByVisibleText("France");
		
		//count of all options
		List<WebElement> allOptions = CountryDrop.getOptions();
		System.out.println("Total no of options: " + allOptions.size());
		
		//text of all options using iterative for loop
		for (int i = 0; i < allOptions.size() ; i++) {
			System.out.println(allOptions.get(i).getText());
		}
		
		//text of all options using enhanced for loop
		for (WebElement option : allOptions) {
			System.out.println(option.getText());
		}
		
		Thread.sleep(5000);
		driver.quit();
		
	}

}
