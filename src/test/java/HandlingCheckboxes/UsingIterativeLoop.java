package HandlingCheckboxes;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UsingIterativeLoop {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		List<WebElement> checkBox = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@class='form-check-input' and @type='checkbox']")));
		
		//select all check boxes
//		for (int i = 0; i < checkBox.size(); i++) {
//			checkBox.get(i).click();
//		}
//		
		//select last 3 check boxes
//		for(int i = 4; i < checkBox.size(); i++) {
//			checkBox.get(i).click();
//		}
		
		//select first 3 check boxes
		for(int i = 0; i <= 2; i++) {
			checkBox.get(i).click();
		}
		
		//unselect check boxes if they are selected
		for(int i = 0; i < checkBox.size(); i++) {
			if(checkBox.get(i).isSelected()) {
				checkBox.get(i).click();
			}
		}
		Thread.sleep(5000);
		driver.quit();
	}

}
