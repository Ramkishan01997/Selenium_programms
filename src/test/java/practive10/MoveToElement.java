package practive10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MoveToElement {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
//		driver.findElement(By.id("")).click();
		WebElement first = driver.findElement(By.xpath("//*[@id=\"menu_pim_viewPimModule\"]"));
		first.click();

		WebElement second = driver.findElement(By.xpath("//*[@id=\"menu_pim_Configuration\"]"));
		WebElement third = driver.findElement(By.xpath("//*[text()=\"Optional Fields\"]"));
		WebElement fouth = driver.findElement(By.xpath("//*[text()=\"Custom Fields\"]"));

		Actions act = new Actions(driver);

		act.moveToElement(second).moveToElement(third).moveToElement(fouth).click().build().perform();

	}

}
