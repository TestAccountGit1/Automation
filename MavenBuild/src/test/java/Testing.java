
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
public class Testing {
    @Test
	public void automationTesting() throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		WebElement radio = driver.findElement(By.xpath("//input[@value='radio3']"));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(100));
		wait.until(ExpectedConditions.visibilityOf(radio));
		
		radio.click();
		
		
		String country = "india";
		
		driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys("ind");
		Thread.sleep(1000);
		List<WebElement> countries = driver.findElements(By.xpath("//ul[@id='ui-id-1']//following::div/text()"));
		for(WebElement count : countries) {
			if(count.getText().equalsIgnoreCase(country)) {
			
				count.click();
			}
		}
		
	}
	
}
