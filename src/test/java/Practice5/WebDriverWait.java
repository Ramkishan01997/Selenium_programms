package Practice5;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverWait {




public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
	
		
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("Selenium");
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys(Keys.RETURN);
		
		
		
		
	}


}
