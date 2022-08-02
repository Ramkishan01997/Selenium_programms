package practice7;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertDemo1 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		
		Alert alert=driver.switchTo().alert();
//		alert.accept();
	
		
		
//		String actText=driver.findElement(By.id("result")).getText();
         
//		String ExpText1="You clicked: Ok";
//		if(actText.contains(ExpText1)) {
//			System.out.println("Test Passed");
//		}else {
//			System.out.println("Test Failed");
//		}
		
		
		alert.dismiss();
		String actText=driver.findElement(By.id("result")).getText();
	       
		String ExpText2="You clicked: Cancel";
		
		if(actText.contains(ExpText2)) {
			System.out.println("Test Passed");
		}else {
			System.out.println("test failed");
		}
		driver.quit();
		
		
	}

}
