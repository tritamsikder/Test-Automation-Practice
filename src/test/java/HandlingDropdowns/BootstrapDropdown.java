package HandlingDropdowns;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BootstrapDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		driver.manage().window().maximize();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		//opens drop down option
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class,'multiselect')]"))).click();
		
		//select single option
		driver.findElement(By.xpath("//input[@value='jQuery']")).click();
		
		//capture all options and find out size
		List<WebElement> options = driver.findElements(By.xpath("//ul[contains(@class,'multiselect')]//label[@class='checkbox']"));
		System.out.println("Number of options: " + options.size());
		
//		printing options from drop down
//		for (WebElement optionText : options) {
//			System.out.println(optionText.getText());
//		}
		
		//using conditions
		for (WebElement option : options) {
			if (option.getText().equals("CSS") || option.getText().equals("Java") || option.getText().equals("Oracle")) {
				option.click();
			}
		}
		
		Thread.sleep(5000);
		driver.quit();
	}

}
