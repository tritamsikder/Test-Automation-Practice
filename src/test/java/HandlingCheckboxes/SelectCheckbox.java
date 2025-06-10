package HandlingCheckboxes;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectCheckbox {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		List<WebElement> ckeckBox = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@class='form-check-input' and @type='checkbox']")));
		for (WebElement CheckBoxNo : ckeckBox) {
			CheckBoxNo.click();
			if (CheckBoxNo.isSelected()) {
				CheckBoxNo.click();
			}
		}
		
		Thread.sleep(5000);
		driver.quit();
	}
}
