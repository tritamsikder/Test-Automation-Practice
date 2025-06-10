package handlingWebTables;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingDynamicTable {

    public static void main(String[] args) throws InterruptedException {

        // Initialize Chrome browser
        WebDriver driver = new ChromeDriver();

        // Set an implicit wait time of 10 seconds
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Open the web page
        driver.get("https://testautomationpractice.blogspot.com/");

        // Maximize the browser window
        driver.manage().window().maximize();

        // Loop through pagination from page 1 to 4
        for (int p = 1; p <= 4; p++) {

            // If not on the first page, click the pagination link for page p
            if (p > 1) {
                driver.findElement(By.xpath("//ul[@id='pagination']//a[.='" + p + "']")).click();
            }

            // Locate all checkboxes (inputs) in the table on the current page
            List<WebElement> list = driver.findElements(By.xpath("//table[@id='productTable']/tbody//input"));

            // Loop through each checkbox and click (select) it
            for (WebElement item : list) {
//                Thread.sleep(1000); // Pause for a second before clicking
                item.click();
            }
        }

        // Wait for 2 seconds before closing the browser
        Thread.sleep(2000);

        // Close the browser
        driver.quit();
    }
}
