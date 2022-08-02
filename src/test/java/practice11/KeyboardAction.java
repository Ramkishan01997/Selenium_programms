package practice11;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyboardAction {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://text-compare.com/");
		
		WebElement logo=driver.findElement(By.xpath("//*[@id=\"inputText1\"]"));
		logo.sendKeys("Selenium automation");
		Actions act=new Actions(driver);
		act.moveToElement(logo).build().perform();
		act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
		
		WebElement w2=driver.findElement(By.id("inputText2"));
		act.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
		act.moveToElement(w2).build().perform();
		act.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
		
		System.out.println(logo.getLocation().getX());
	}

}
