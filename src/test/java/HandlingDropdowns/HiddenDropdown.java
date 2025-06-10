package HandlingDropdowns;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HiddenDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		//Login
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//clicking on PIM
		driver.findElement(By.xpath("//a[normalize-space()='PIM']")).click();
		
		//clicking on drop down
		driver.findElement(By.xpath("//div[@class='oxd-table-filter']//div[6]//div[1]//div[2]//div[1]//div[1]//div[1]")).click();
		
		//clicking on single option
//		driver.findElement(By.xpath("//div[@role='listbox']//span[.='Chief Financial Officer']")).click();
		
		//getting all option
		List<WebElement> options = driver.findElements(By.xpath("//div[@role='listbox']//span"));
		
		//size of the list
		System.out.println(options.size());
		
		//getting all option
		for (WebElement option : options) {
			System.out.println(option.getText());
		}
		
		Thread.sleep(5000);
		driver.quit();
	}

}
