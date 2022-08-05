package package21;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

	WebDriver driver;
	PageObject1 pg;

	@BeforeClass
	void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	}

	@Test(priority = 1)
	void logoPresence() {
		pg = new PageObject1(driver);
		Assert.assertEquals(pg.check_logo_presence(), true);
	}

	@Test(priority = 2)
	void loginCheck() {
		pg.setUserName("Admin");
		pg.setPassWord("admin123");
		pg.clickLogin();
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");

	}

	@Test(priority = 3)
	void Logout_check() throws InterruptedException {
		pg.clickLogoutdrp();
		Thread.sleep(3000);
		pg.logout();
		Assert.assertEquals(pg.check_logo_presence(), true);

	}

	@AfterClass
	void teardown() {
		driver.quit();
	}

}
