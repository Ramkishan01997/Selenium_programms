package package18;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProvider1 {
	
	WebDriver driver;
	
	@BeforeClass
	void setup() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	
	
	
	@Test(dataProvider="userlogin")
	void LoginMethod(String username,String pass) {
		driver.get("https://demo.nopcommerce.com/login");
		driver.manage().window().maximize();
		System.out.println(username);
		driver.findElement(By.xpath("//*[@id='Email']")).sendKeys(username);
		driver.findElement(By.xpath("//*[@id='Password']")).sendKeys(pass);
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		String act_title=driver.getTitle();
		String exptitle="nopCommerce demo store";
		Assert.assertEquals(act_title, exptitle);
		
	}
	
	
	@DataProvider(name="userlogin")
	String [][]dataprovider(){
		String data[][]= {{"abc@gmail.com","abc@123"},{"bhbje","ok5666"},{"rty@gmail.com","oopp@789"},{"ghjj@ui.com","5662"}
				
		};
		return data;
	}
	
	@AfterClass
	void teardown() {
	driver.close();
	}

}
