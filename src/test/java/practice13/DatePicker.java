package practice13;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://jqueryui.com/datepicker/");
		driver.switchTo().frame(0);

		String month = "October";
		String year = "2022";
		String date = "10";

		driver.findElement(By.xpath("//input[@id=\"datepicker\"]")).click();
//		driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("01/02/2022");

		while (true) {
			String mon = driver.findElement(By.xpath("//*[@class=\"ui-datepicker-month\"]")).getText();
			String years = driver.findElement(By.xpath("//*[@class=\"ui-datepicker-year\"]")).getText();

			if (mon.equals(month) && years.equals(year)) {
				break;
			}

			driver.findElement(By.xpath("//*[text()='Next']")).click();

		}
		List<WebElement> dates = driver.findElements(By.xpath("//*[@class='ui-datepicker-calendar']//td"));

		for (WebElement d : dates) {
			if (d.getText().equals(date)) {
				d.click();
				break;
			}
		}
		
		System.out.println(driver.findElement(By.xpath("//input[@id='datepicker']")).getText());
	}

}
