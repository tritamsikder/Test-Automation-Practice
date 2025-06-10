package chromeOptionHandle;

//import java.io.File;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class HeadlessTesting {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions option = new ChromeOptions();
		Thread.sleep(2000);
		option.addArguments("--headless=new");
		
		WebDriver driver = new ChromeDriver(option);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rxpeptides.webgen.me/shop/");
		driver.manage().window().maximize();
//		System.out.println(driver.getTitle());	
		
		if (driver.getTitle().equals("Shop – Peptide Rx")) {
		    System.out.println("Pass");
		} else {
		    System.out.println("Fail");
		    System.out.println("Actual title: " + driver.getTitle());
		}

		
		Thread.sleep(2000);
		driver.quit();
	}

}
