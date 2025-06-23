package assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DatePickerHandle1 {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://dummy-tickets.com/buyticket");
        driver.manage().window().maximize();

        // Clicking on 'Both'
        driver.findElement(By.xpath("//a[normalize-space()='Both']")).click();

        // Entering 'from' location
        WebElement fromInput = driver.findElement(By.xpath("(//input[@name='source[]'])[4]"));
        fromInput.sendKeys("te");

        // Selecting 'from' airport from suggestions
        List<WebElement> fromList = driver.findElements(By.xpath("//ul[@class='suggestions-list']//li//p"));
        for (WebElement from : fromList) {
            System.out.println(from.getText());
            if (from.getText().equals("Aalborg Airport,")) {
                js.executeScript("arguments[0].scrollIntoView(true);", from);
                wait.until(ExpectedConditions.elementToBeClickable(from)).click();
                break;
            }
        }

        // Entering 'to' location
        WebElement toInput = driver.findElement(By.xpath("(//input[@name='destination[]'])[4]"));
        toInput.sendKeys("te");

        // Selecting 'to' airport from suggestions
        List<WebElement> toList = driver.findElements(By.xpath("//ul[@class='suggestions-list']//li//p"));
        for (WebElement to : toList) {
            System.out.println(to.getText());
            if (to.getText().equals("Abuja International Airport,")) {
                js.executeScript("arguments[0].scrollIntoView(true);", to);
                wait.until(ExpectedConditions.elementToBeClickable(to)).click();
                break;
            }
        }

        Thread.sleep(2000); // Just to see the result before closing
        driver.quit();
    }
}
