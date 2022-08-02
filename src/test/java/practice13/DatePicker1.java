package practice13;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker1 {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
		driver.findElement(By.cssSelector("input#dob")).click();
		String month="Oct";
		String Year="2022";
		String date="10";
		Select monthDrp=new Select(driver.findElement(By.xpath("//*[@class='ui-datepicker-month']")));
		
		monthDrp.selectByVisibleText(month);
		
		Select yearDrp=new Select(driver.findElement(By.xpath("//*[@class='ui-datepicker-year']")));
		
		List<WebElement> dates=driver.findElements(By.xpath("//*[@class='ui-datepicker-calendar']//td"));
		
		for(WebElement d:dates) {
			if(d.getText().equals(date)) {
				d.click();
				break;
			}
		}
		TakesScreenshot sc=(TakesScreenshot)driver;
		File src=sc.getScreenshotAs(OutputType.FILE);
		File trg=new File("C:\\Users\\ramkishan\\eclipse-workspace\\java\\orangehrmDemo\\target\\p1.png");
		FileUtils.copyFile(src, trg);
		
	}

}
