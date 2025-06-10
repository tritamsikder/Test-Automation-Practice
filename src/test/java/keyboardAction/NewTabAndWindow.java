package keyboardAction;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewTabAndWindow {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		//Open URL in new tab
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://www.orangehrm.com/");
		
		//Open URL in new browser window
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://www.orangehrm.com/en/book-a-free-demo");
		
		
		Thread.sleep(5000);
		driver.quit();
	}

}
