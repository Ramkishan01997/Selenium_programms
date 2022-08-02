package Practice2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorsDemo2 {

	public static void main(String[] args) {
		
		
		 WebDriverManager.chromedriver().setup();
	
		 WebDriver driver=new ChromeDriver();
		 
		 driver.manage().window().maximize();
		 driver.get("http://automationpractice.com/index.php");
		 
		 
		 
		 List <WebElement> links=driver.findElements(By.tagName("a"));
		 
		 System.out.println(links.size());
		 
		 
		 List <WebElement> images=driver.findElements(By.tagName("img"));
		 
		 System.out.println(images.size());
		 
		 
		 List<WebElement> slider=driver.findElements(By.className("homeslider-container"));
		 
		 System.out.println(slider.size());
		 
		 
		 for(Object s:slider) {
			 System.out.println(s);
		 }
		 driver.quit();
	
	}

}
