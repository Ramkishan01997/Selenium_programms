package package20;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class nopCommerceTest {
	
	WebDriver driver;
	@BeforeClass
	void setup() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
	}
	
	@Test(priority=1)
	void logoDisplayCheck() {
		
		try
		{
			 boolean Status=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']")).isDisplayed();
			Assert.assertEquals(Status, true);
		}
		catch(NoSuchElementException e){
			Assert.assertTrue(false);
			
		}
	}
	
	@Test(priority=2)
	void loginTest() {
		try {
			driver.findElement(By.xpath("//a[text()='Log in']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id='Email']")).sendKeys("xyz123@gmail.com");
			driver.findElement(By.xpath("//*[@id='Password']")).sendKeys("test123");
			driver.findElement(By.xpath("//*[@class='button-1 login-button']")).click();
			Thread.sleep(3000);
			
			boolean Status=driver.findElement(By.linkText("My account")).isDisplayed();
			Assert.assertEquals(Status, true);
		}catch(Exception e) {
			Assert.fail();
		}
	}
	
	@Test(priority=3,dependsOnMethods= {"loginTest"})
	void logout() throws InterruptedException {
		driver.findElement(By.linkText("Log out")).click();
		Thread.sleep(3000);
		boolean Status=driver.findElement(By.linkText("Register")).isDisplayed();
		Assert.assertEquals(Status, true);
	}
	@AfterClass
	void tearDown() {
		driver.quit();
	}
	

}
