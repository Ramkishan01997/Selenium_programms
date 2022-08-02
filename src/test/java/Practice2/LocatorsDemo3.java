package Practice2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorsDemo3 {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.opencart.com/");
		
		
		
		List<WebElement> links=driver.findElements(By.tagName("a"));
		
		System.out.println(" number of links  "+links.size());
		
		
		
		List <WebElement> images=driver.findElements(By.tagName("img"));
		
		System.out.println("number of images  "+images);
     
		
		List <WebElement> slider=driver.findElements(By.className("text-center"));
		
		System.out.println("slider    "+slider.size());
		
//	driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[2]/form/div/div[2]/div[1]/h4/a")).click();
//		
//		String actTitle=driver.getTitle();
//		
//		String expTitle="Your Store";
//		if(actTitle.equals(expTitle)) {
//			System.out.println("test passsed");
//		}else {
//			System.out.println("Test failed");
//		}
	driver.findElement(By.xpath("//*[@class=\"nav navbar-nav\"]/li[4]")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.partialLinkText("App")).click();
		
		driver.quit();
	
	}

}
