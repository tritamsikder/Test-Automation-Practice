package Assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SwitchingBetweenTabs {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='Wikipedia1_wikipedia-search-input']"))).sendKeys("Test");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='submit']"))).click();
		List<WebElement> searchLinks = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='wikipedia-search-result-link']")));
		//Count the number of links
		System.out.println(searchLinks.size());
		//Store the link text
		List<String> linkTexts = new ArrayList<String>();	
		for (WebElement link : searchLinks) {
			linkTexts.add(link.getText());
//			System.out.println(link.getText());
		}
		//Click on each link using fresh locators
		for (String text : linkTexts) {
			driver.findElement(By.linkText(text)).click();
		}
		//Getting all tab IDs using getWindowHandles()
		Set<String> TabIds = driver.getWindowHandles();
		for (String IDs : TabIds) {
			@Nullable
			String title = driver.switchTo().window(IDs).getTitle();
			System.out.println(driver.switchTo().window(IDs).getTitle());
			if (title.equals("Test cricket - Wikipedia")) {
				driver.close();
			} if (title.equals("Test (2025 film) - Wikipedia")) {
				driver.findElement(By.xpath("//input[@id='vector-main-menu-dropdown-checkbox']")).click();
				driver.close();
			} if (title.equals("Testicle - Wikipedia")) {
				driver.findElement(By.xpath("//a[@title='Discuss improvements to the content page [alt-shift-t]']//span[contains(text(),'Talk')]")).click();
				driver.close();
			} if (title.equals("Testosterone - Wikipedia")) {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='searchInput']"))).sendKeys("Test");
				driver.findElement(By.xpath("//form[@id='searchform']//button[@class='cdx-button cdx-button--action-default cdx-button--weight-normal cdx-button--size-medium cdx-button--framed cdx-search-input__end-button'][normalize-space()='Search']")).click();
				driver.close();
			} if (title.equals("Test - Wikipedia")) {
				driver.findElement(By.xpath("//input[@id='p-lang-btn-checkbox']")).click();
				driver.close();
			}
			
		}
		Thread.sleep(5000);
		driver.quit();
	}

}
