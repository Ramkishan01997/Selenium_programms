package Practice4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ConditionalMethods {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
		
		
		WebElement inputBox=driver.findElement(By.id("travname"));
		System.out.println(inputBox.isDisplayed());
		
		WebElement SexMale=driver.findElement(By.id("sex_1"));
		System.out.println(SexMale.isSelected());
		SexMale.click();
		
		System.out.println(SexMale.isSelected());
		
	}

}
