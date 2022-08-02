package practive10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragandDropExercise {
	public static void main(String [] args) {
	 WebDriverManager.chromedriver().setup();
	 WebDriver driver=new ChromeDriver();
	 
	 driver.get("https://demo.guru99.com/test/drag_drop.html");
	 
		WebElement e1=driver.findElement(By.xpath("//*[@id=\"credit2\"]"));
		WebElement e2=driver.findElement(By.id("bank"));
		WebElement e3=driver.findElement(By.id("fourth"));
		WebElement e4=driver.findElement(By.id("amt7"));
		WebElement e5=driver.findElement(By.id("credit1"));
		WebElement e6=driver.findElement(By.id("loan"));
		WebElement e7=driver.findElement(By.id("fourth"));
		WebElement e8=driver.findElement(By.id("amt8"));
		
		Actions act=new Actions(driver);
		act.dragAndDrop(e1, e2).build().perform();
		act.dragAndDrop(e3, e4).build().perform();
		act.dragAndDrop(e5, e6).build().perform();
		act.dragAndDrop(e7, e8).build().perform();
		String txt=driver.findElement(By.xpath("//*[text()=\"Perfect!\"]")).getText();
		if(txt.equals("Perfect!")) {
			System.out.println("test passed");
		}
		
		
		
		
	}

}
