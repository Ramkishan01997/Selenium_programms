package practice12;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Fruitcart {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	

	String prod1="tom";
		driver.findElement(By.xpath("//*[@class=\"search-keyword\"]")).sendKeys(prod1);
Thread.sleep(3000);
		String productName = driver.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();
		System.out.println(productName);
	

	
		System.out.println("hello");
		driver.findElement(By.linkText("Top Deals")).click();
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> i1 = s1.iterator();
		String parentwindow = i1.next();
		String childwindow = i1.next();
		driver.switchTo().window(childwindow);
		driver.findElement(By.xpath("//*[@id=\"search-field\"]")).sendKeys("tom");

		String offerPageProductName = driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();
		System.out.println(offerPageProductName);

	}

}
