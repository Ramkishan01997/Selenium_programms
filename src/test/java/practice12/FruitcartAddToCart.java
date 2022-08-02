package practice12;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FruitcartAddToCart {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();

		driver.findElement(By.className("search-keyword")).sendKeys("tom");
		Thread.sleep(3000);
		String prodName = driver.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();

		System.out.println(prodName);

		WebElement increment = driver.findElement(By.cssSelector("a.increment"));

		for (int i = 0; i < 3; i++) {
			increment.click();
			i++;
		}
		driver.findElement(By.xpath("//button[text()=\"ADD TO CART\"]")).click();

		driver.findElement(By.xpath("//img[@alt=\"Cart\"]")).click();

		driver.findElement(By.xpath("//button[text()=\"PROCEED TO CHECKOUT\"]")).click();

		String expText = driver.findElement(By.xpath("//p[@class=\"product-name\"]")).getText().split("-")[0].trim();

		if (prodName.equals(expText)) {
			System.out.println(" test is passed");
		}
	}

}
