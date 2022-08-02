package Practice5;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitWait {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.google.com/");
driver.findElement(By.xpath("//*[@class=\"gLFyf gsfi\"]")).sendKeys("selenium");
driver.findElement(By.xpath("//*[@class=\"gLFyf gsfi\"]")).sendKeys(Keys.RETURN);
System.out.println(driver.getTitle());
driver.quit();
	}

}
