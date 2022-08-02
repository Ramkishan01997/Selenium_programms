package Day16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest_testng {
	public WebDriver driver;
	
	
	@Test(priority=1)
	void openBrowser() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://admin-demo.nopcommerce.com/login");
	}
	
	@Test (priority=2)
	void login() {
	WebElement username=driver.findElement(By.xpath("//*[@id='Email']"));
		username.clear();
		username.sendKeys("admin@yourstore.com");
		WebElement pass=driver.findElement(By.xpath("//*[@id='Password']"));
		pass.clear();
		pass.sendKeys("admin");
		
		driver.findElement(By.xpath("//*[@class='button-1 login-button']")).click();
	}
	
	@Test(priority=3)
	void validation() {
		String act_title=driver.findElement(By.xpath("//h1[contains(text(),'Dashboard')]")).getText();
		if(act_title.contains("Dashboard")) {
			Assert.assertTrue(true);
		}
	}
	@Test(priority=4)
	void closeBrowser() {
		driver.close();
	}
	

}
