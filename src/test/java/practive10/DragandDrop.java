package practive10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragandDrop {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		
		
		WebElement capital1=driver.findElement(By.id("box1"));
		WebElement country1=driver.findElement(By.id("box101"));
		
		WebElement capital2=driver.findElement(By.id("box2"));
		WebElement country2=driver.findElement(By.id("box102"));
		
		Actions act=new Actions(driver);
		
		act.dragAndDrop(capital1, country1).build().perform();
		
		act.clickAndHold(capital2).moveToElement(country2).release().build().perform();
	}

}
