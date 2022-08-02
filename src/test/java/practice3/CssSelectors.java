package practice3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CssSelectors {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();
         driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("electronics");
         
         driver.findElement(By.cssSelector("button.button-1[type='submit']")).click();
         
         System.out.println(driver.getTitle());
         
	       
	}

}
