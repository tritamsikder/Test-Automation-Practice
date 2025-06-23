package assignments;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticTableDataFetch {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://blazedemo.com/");
		driver.manage().window().maximize();
		
		WebElement departureDropdown = driver.findElement(By.xpath("//select[@name='fromPort']"));
		Select departureCity = new Select(departureDropdown);
		departureCity.selectByValue("Boston");
		
		WebElement destinationDropdown = driver.findElement(By.xpath("//select[@name='toPort']"));
		Select destinationCity = new Select(destinationDropdown);
		destinationCity.selectByValue("London");
		
		driver.findElement(By.xpath("//input[@value='Find Flights']")).click();
		
		String[] priceList = new String[5];

		for (int r = 0; r < 5; r++) {
		    priceList[r] = driver.findElement(By.xpath("//table[@class='table']/tbody/tr[" + (r + 1) + "]/td[6]")).getText();
		}

		// Step 1: Convert String[] to double[] by removing $ and any non-numeric characters
		double[] prices = new double[priceList.length];
		for (int i = 0; i < priceList.length; i++) {
		    prices[i] = Double.parseDouble(priceList[i].replaceAll("[^\\d.]", ""));
		}

		// Step 2: Sort the prices in ascending order
		Arrays.sort(prices);

		// Step 3: Convert back to String[] with $ symbol and 2 decimal places
		String[] sortedPriceList = new String[prices.length];
		for (int i = 0; i < prices.length; i++) {
		    sortedPriceList[i] = "$" + String.format("%.2f", prices[i]);
		}

		// Step 4: Get the lowest price as a String
		String lowestPrice = sortedPriceList[0];

		// Output results
		System.out.println("Sorted Price List: " + Arrays.toString(sortedPriceList));
		System.out.println("Lowest Price: " + lowestPrice);
		
		for (int r = 1; r <= 5; r++) {
			if (driver.findElement(By.xpath("//table[@class='table']/tbody/tr["+r+"]/td[6]")).getText().equals(lowestPrice)) {
				Thread.sleep(2000);
				driver.findElement(By.xpath("//table[@class='table']/tbody/tr["+r+"]/td[1]")).click();
				break;
			}
		}
		
		driver.findElement(By.xpath("//input[@id='inputName']")).sendKeys("Test Name");
		driver.findElement(By.xpath("//input[@id='address']")).sendKeys("Test Address");
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Test City");
		driver.findElement(By.xpath("//input[@id='state']")).sendKeys("test State");
		driver.findElement(By.xpath("//input[@id='zipCode']")).sendKeys("12345");
		Select VisaDropdown = new Select(driver.findElement(By.xpath("//select[@id='cardType']")));
		VisaDropdown.selectByIndex(1);
		driver.findElement(By.xpath("//input[@id='creditCardNumber']")).sendKeys("4242424242424242");
		driver.findElement(By.xpath("//input[@id='nameOnCard']")).sendKeys("John Doe");
		driver.findElement(By.xpath("//input[@id='rememberMe']")).click();
		driver.findElement(By.xpath("//input[@value='Purchase Flight']")).click();
		
		if(driver.findElement(By.tagName("h1")).getText().equals("Thank you for your purchase today!")) {
			System.out.println("Test Case Pass");
		} else {
			System.out.println("Test Case Failed");
		}
		
		Thread.sleep(2000);
		driver.quit();
		
	}

}
