package package14;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenShotDemo {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
		
		WebElement cart=driver.findElement(By.xpath("//*[@class='product-grid home-page-product-grid']"));
		
		TakesScreenshot sc=(TakesScreenshot)driver;
		String dateform=new SimpleDateFormat("DD-MM-YYYY-HH-MM-SS").format(new Date());
		Date date=new Date();
		long time=date.getTime();
		Timestamp ts=new Timestamp(time);
		System.out.println(ts);
		System.out.println(dateform);
		File src=sc.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir")+"\\target\\"+dateform+".png");
		FileUtils.copyFile(src, target);
		
		
		// capture screenshot of specific webelement
		src=cart.getScreenshotAs(OutputType.FILE);
		target=new File(System.getProperty("user.dir")+"\\target\\cart.png");
		FileUtils.copyFile(src, target);
		
		//capture imange of specific webeleemnt
		WebElement  mobile=driver.findElement(By.xpath("//*[@id='nivo-slider']"));
		src=mobile.getScreenshotAs(OutputType.FILE);
		target=new File(System.getProperty("user.dir")+"\\target\\mobile.png");
		FileUtils.copyFile(src, target);
		
	}

}
