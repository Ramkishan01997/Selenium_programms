package Practice5;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWait {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		

	
		//WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(10)); // declaration  one time
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		
		
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("Selenium");
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys(Keys.RETURN);
		
		try
		{
		WebElement link_ele=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Selenium']")));
		link_ele.click();
		}
		catch(Exception e)
		{
			System.out.println("Element not found...");
		}
		
		
		
	}

}
