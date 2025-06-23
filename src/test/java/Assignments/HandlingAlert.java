package assignments;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingAlert {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://mypage.rediff.com/login/dologin");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtlogin']"))).sendKeys("Test");
		driver.findElement(By.xpath("//input[@id='pass_box']")).sendKeys("Test");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();
		
		Thread.sleep(5000);
		driver.quit();
	}

}
