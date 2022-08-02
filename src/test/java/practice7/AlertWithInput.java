package practice7;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertWithInput {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
	
	
	driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
	
	Alert alert=driver.switchTo().alert();
	
	alert.sendKeys("ok");
	//alert.accept();
	alert.dismiss();
	String txt=driver.findElement(By.id("result")).getText();
	
//	if(txt.contains("ok")) {
//		System.out.println("Test Passed");
//	}else {
//		System.out.println("Test Failed");
//	}
	if(txt.contains("null")) {
		System.out.println("Test Passed");
	}else {
		System.out.println("Test Failed");
	}
	}

}
