package Assignments;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatingBrokenLinkAndEmptyLink {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://lummus-dev.webgen.me/");
		driver.manage().window().maximize();
		
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		System.out.println("Total no of links: " + allLinks.size());
		int count = 0;
		
		for (WebElement link : allLinks) {
			@Nullable
			String hrefLinkValue = link.getAttribute("href");
			if (hrefLinkValue == null || hrefLinkValue.isEmpty()) {
				System.out.println("\n[Broken HREF] Element Identified:");
				System.out.println("Text       : " + link.getText());
				System.out.println("Tag Name   : " + link.getTagName());
				System.out.println("Location   : " + link.getLocation());
				System.out.println("Outer HTML : " + link.getAttribute("outerHTML"));
				continue;
			}
			
			try {
				URL linkURL = new URL(hrefLinkValue);
				HttpURLConnection conn = (HttpURLConnection) linkURL.openConnection();
				conn.connect();
				
				if (conn.getResponseCode() >= 400) {
					count++; 
					System.out.println(hrefLinkValue + " broken link");
				}
			} catch (Exception e) {
				// Optional: log error if needed
			}
		}
		System.out.println("\nTotal number of broken links: " + count);
		
		Thread.sleep(2000);
		driver.quit();
	}
}

