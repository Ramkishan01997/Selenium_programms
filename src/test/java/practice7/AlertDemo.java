package practice7;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertDemo {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		driver.findElement(By.xpath("//button[text()=\"Click for JS Alert\"]")).click();

//		Alert alert=driver.switchTo().alert();
//		//*** 1st way
//	alert.accept();
//		String Text=driver.findElement(By.id("result")).getText();
//		String expText="You successfully clicked an alert";
//		
//		if(Text.contains(expText)) {
//			System.out.println("test Passed");
//		}
//		else {
//			System.out.println("Test failed");
//		}
		///*** second way
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		
		
		Alert alert=wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();
		String Text=driver.findElement(By.id("result")).getText();
		String expText="You successfully clicked an alert";
		
		if(Text.contains(expText)) {
			System.out.println("test Passed");
		}
		else {
			System.out.println("Test failed");
		}
		// button[text()="Click for JS Alert"]
	}

}
