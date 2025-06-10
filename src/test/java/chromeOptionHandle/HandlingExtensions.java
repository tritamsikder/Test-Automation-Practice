package chromeOptionHandle;

import java.io.File;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HandlingExtensions {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		File crx1 = new File("C:\\Users\\HP\\eclipse-workspace\\CRX_fils\\SelectorsHub_crx.crx");
		File crx2 = new File("C:\\Users\\HP\\eclipse-workspace\\CRX_fils\\Stands-AdBlocker.crx");
		// Create list of extensions
        List<File> extensions = Arrays.asList(crx1, crx2);

        // Set ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.addExtensions(extensions);
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://text-compare.com/");
		driver.manage().window().maximize();
		
		System.out.println(driver.getTitle());
		
		Thread.sleep(2000);
		driver.quit();
	}

}
