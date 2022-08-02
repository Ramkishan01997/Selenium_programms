package Practice2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorsDemo1 {

	public static void main(String[] args) {

		 WebDriverManager.chromedriver().setup();
		 WebDriver driver=new ChromeDriver();
		 
		 driver.manage().window().maximize();
		 driver.get("http://automationpractice.com/index.php");
		 
		 
		 driver.findElement(By.id("search_query_top")).sendKeys("T-shirts");
		 
		 driver.findElement(By.name("submit_search")).click();
		 
		 driver.findElement(By.linkText("Printed Chiffon Dress")).click();
		 
		 
		 
	}

}
