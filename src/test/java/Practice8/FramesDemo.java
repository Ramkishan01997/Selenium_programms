package Practice8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesDemo {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
		driver.switchTo().frame("classFrame");
		driver.findElement(By.linkText("org.openqa.selenium")).click();
		System.out.println(driver.getTitle());
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("packageListFrame");
		driver.findElement(By.linkText("org.openqa.selenium.chrome")).click();
		System.out.println(driver.getTitle());

		driver.switchTo().defaultContent();
		driver.switchTo().frame("packageFrame");
	//	driver.findElement(By.xpath("//body/main[1]/ul[1]/li[4]/a[1]"));
		driver.findElement(By.xpath("//span[normalize-space()='WebDriver']")).click();
		System.out.println(driver.getTitle());
		
		
	}

}
