package Practice4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetMethods {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.navigate().to("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
		
		
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
	//	System.out.println(driver.getPageSource());

		
		driver.findElement(By.xpath("//a[contains(text(),'Contact')]")).click();
		
		System.out.println(driver.getTitle());
		Thread.sleep(3000);
		driver.navigate().back();
		System.out.println(driver.getTitle());
		Thread.sleep(3000);
		driver.navigate().forward();
		System.out.println(driver.getTitle());
	}

}
