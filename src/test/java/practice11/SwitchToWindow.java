package practice11;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwitchToWindow {

	public static void main(String[] args) {
WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
				
		driver.get("https://www.opencart.com/");
		driver.switchTo().newWindow(WindowType.TAB);
		//driver.switchTo().newWindow(WindowType.TAB); // opens in another tab
//		driver.switchTo().newWindow(WindowType.WINDOW);  // opens in another window
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}

}
