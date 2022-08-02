package practice7;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AuthenticationAlert {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		// driver.get("http://the-internet.herokuapp.com/basic_auth");

		// To handle authentication popup we need to pass username and password

		driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
		driver.manage().window().maximize();

	}

}
