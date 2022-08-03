package package19;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParameterTest {
	WebDriver driver;

	@Parameters({ "url", "browser" })
	@BeforeClass
	void setup(String url, String browser) {
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.get(url);
		driver.manage().window().maximize();
	}

	@Test//(invocationCount=7) used to run same test case multiple times
	void logoTest() {
		Boolean status = driver.findElement(By.xpath("//*[@id='divLogo']")).isDisplayed();
		Assert.assertTrue(status);
	}

	@AfterClass
	void teardown() {
		driver.quit();
	}

}
