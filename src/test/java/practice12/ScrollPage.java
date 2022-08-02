package practice12;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollPage {

	public static void main(String[] args) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.countries-ofthe-world.com/flags-of-the-world.html");
	driver.manage().window().maximize();
	
	JavascriptExecutor js=(JavascriptExecutor)driver;
//	js.executeScript("window.scrollBy(0,2000)","");
	WebElement flag=driver.findElement(By.xpath("//*[@alt=\"Flag of India\"]"));
//	js.executeScript("arguments[0].scrollIntoView();",flag);
	
	
	js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	System.out.println(js.executeScript("return window.pageYOffset;"));
	Thread.sleep(1000);
	js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
	js.executeScript("document.body.style.background='red'");
	js.executeScript("document.body.style.size='40px'");
	}

}
