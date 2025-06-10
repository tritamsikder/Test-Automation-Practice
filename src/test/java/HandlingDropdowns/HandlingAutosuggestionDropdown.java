package HandlingDropdowns;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingAutosuggestionDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='APjFqb']")));
		searchBox.sendKeys("Test");
		List<WebElement> searchList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@role='listbox']/li")));
		System.out.println(searchList.size());
//		for (WebElement searchItem : searchList) {
//			System.out.println(searchItem.getText());
//			
//		}
		searchBox.sendKeys("Test");
		
		for (int i = 0; i < searchList.size(); i++) {
			searchList.get(i).click();
			Thread.sleep(4000);
			driver.navigate().back();
			Thread.sleep(2000);
			searchBox.sendKeys("Test");
			Thread.sleep(4000);
		}
		
		Thread.sleep(2000);
		driver.quit();
	}

}
