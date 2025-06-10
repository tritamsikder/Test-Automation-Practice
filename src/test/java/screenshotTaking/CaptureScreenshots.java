package screenshotTaking;

import java.io.File;
//import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.io.FileHandler;

public class CaptureScreenshots {

    public static void main(String[] args) {
        // Launch Chrome browser
        WebDriver driver = new ChromeDriver();
        
        // Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        // Open the URL
        driver.get("https://demo.nopcommerce.com/");
        
        // Maximize the window
        driver.manage().window().maximize();

        // Take full page screenshot
        TakesScreenshot ts = (TakesScreenshot) driver;

        // Capture screenshot as a file
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);

        // Define the destination file path where screenshot will be saved
        // user.dir will return the current project directory
        File destinationFile = new File(System.getProperty("user.dir") + "\\screenshots\\homepage.png");
        
        sourceFile.renameTo(destinationFile);

//        try {
//            // Copy the screenshot to the specified path
//            FileHandler.copy(sourceFile, destinationFile);
//            System.out.println("Screenshot saved successfully.");
//        } catch (IOException e) {
//            System.out.println("Failed to save screenshot: " + e.getMessage());
//        }

        // Close the browser
        driver.quit();
    }
}
