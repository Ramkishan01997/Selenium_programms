package practive10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsClass {

	public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
	
	
	
	Actions act=new Actions(driver);
	WebElement btn=driver.findElement(By.xpath("//span[text()=\"right click me\"]"));
	act.contextClick(btn).build().perform();	
	
	
	}

}
