package Practice5;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;


public class FluentWait {
	public static void main(String[] args) throws InterruptedException {
		
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	
	// Waiting 30 seconds for an element to be present on the page, checking
	// for its presence once every 5 seconds.
	
	Wait<WebDriver> mywait = ((Object) new FluentWait(driver)
		       .withTimeout(Duration.ofSeconds(30)))
		       .pollingEvery(Duration.ofSeconds(5))
		       .ignoring(NoSuchElementException.class);
		
	
	driver.get("https://www.google.com/");
	driver.manage().window().maximize();
	
	
	driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("Selenium");
	driver.findElement(By.xpath("//input[@title='Search']")).sendKeys(Keys.RETURN);
	
	
  WebElement link_ele = mywait.until(new Function<WebDriver, WebElement>() 
  			{
			     public WebElement apply(WebDriver driver) 
			     {
			       return driver.findElement(By.xpath("//h3[text()='Selenium']"));
			     }
  			});
	  

  link_ele.click();
	}

	private Object withTimeout(Duration ofSeconds) {
		// TODO Auto-generated method stub
		return null;
	}


}
