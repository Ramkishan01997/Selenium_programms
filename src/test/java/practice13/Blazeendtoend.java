package practice13;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Blazeendtoend {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://blazedemo.com/");
		Select depcity = new Select(driver.findElement(By.xpath("//*[@name='fromPort']")));

		depcity.selectByVisibleText("Paris");

		Select descity = new Select(driver.findElement(By.xpath("//*[@name='toPort']")));

		descity.selectByVisibleText("London");

		driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//tbody/tr[1]/td[1]/input[1]")).click();
		driver.findElement(By.id("inputName")).sendKeys("Ramkishan");

		driver.findElement(By.name("address")).sendKeys("Barbadi t qpurna");

		driver.findElement(By.name("city")).sendKeys("purna");
		driver.findElement(By.name("state")).sendKeys("Maharashtra");
		driver.findElement(By.id("zipCode")).sendKeys("431511");

		Select card = new Select(driver.findElement(By.name("cardType")));
		card.selectByVisibleText("Visa");

		driver.findElement(By.id("creditCardNumber")).sendKeys("4562223336522");
		driver.findElement(By.name("creditCardMonth")).sendKeys("12");
		driver.findElement(By.id("creditCardYear")).sendKeys("2022");
		driver.findElement(By.name("nameOnCard")).sendKeys("Ramkishan Suryawanshi");
		driver.findElement(By.name("rememberMe")).click();
		driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();
		System.out.println(driver.findElement(By.xpath("//*[@class='container hero-unit']/h1")).getText());
		;

	}

}
