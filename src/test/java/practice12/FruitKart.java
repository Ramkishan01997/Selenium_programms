package practice12;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FruitKart {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
		String[] names = { "Cucumber", "Brocolli" };
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

		for (int i = 0; i < products.size(); i++) {
			String prod = products.get(i).getText().split("-")[0].trim();
			List pname = Arrays.asList(names);
			if (pname.contains(prod)) {
				System.out.println(prod);
				driver.findElements(By.xpath("//button[text()=\"ADD TO CART\"]")).get(i).click();

			}
		}
		driver.quit();

	}

}
