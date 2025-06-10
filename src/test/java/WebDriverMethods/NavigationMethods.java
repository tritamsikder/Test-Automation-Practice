package WebDriverMethods;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigationMethods {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.navigate().refresh();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Online Trainings']"))).click();
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().back();
		driver.navigate().refresh();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='Wikipedia1_wikipedia-search-input']"))).sendKeys("Test");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='submit']"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Test']"))).click();
		
		Set<String> PageIds = driver.getWindowHandles();
		
		//Approach using loop
		
//		for (String Ids : PageIds) {
//			@Nullable
//			String pageTitle = driver.switchTo().window(Ids).getTitle();
//			if (pageTitle.equals("Automation Testing Practice: GUI Elements")) {
//				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='name']"))).sendKeys("Test Name");
//				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email']"))).sendKeys("test@test.com");
//				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='phone']"))).sendKeys("9876543210");
//				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='textarea']"))).sendKeys("Test Address");
//			} else if (pageTitle.equals("Test - Wikipedia")) {
//				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='searchInput']"))).sendKeys("Test0");
//				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@id='searchform']//button[@class='cdx-button cdx-search-input__end-button'][normalize-space()='Search']"))).click();
//				driver.close();
//			}
//			
//		}
		
		//Approach using List Collection
		
		List<String> Ids = new ArrayList<String>(PageIds);
		String parentPage = Ids.get(0);
		String childPage = Ids.get(1);
		
		System.out.println(driver.switchTo().window(parentPage).getTitle());
		System.out.println(driver.switchTo().window(childPage).getTitle());
		
		Thread.sleep(5000);
		driver.quit();
	}

}
