package Practice6;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownItem {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.opencart.com/index.php?route=account/register");
//****//
		WebElement drp = driver.findElement(By.xpath("//*[@name=\"country_id\"]"));
		Select dropdown = new Select(drp);
		List <WebElement> options=dropdown.getOptions();
		System.out.println("size of options : "  +options.size());
		
//		for(int i=0;i<options.size();i++) {
//			System.out.println(options.get(i).getText());
//		}
		
//		for(WebElement option:options) {
//			System.out.println(option.getText());
//		}
//		for(WebElement option:options) {
//			System.out.println(option.getText());
//			if(option.getText().equals("Aruba")) {
//				option.click();
//			}
		//	}
//		dropdown.selectByIndex(2);
//		dropdown.selectByValue("5");
		//	dropdown.selectByVisibleText("India");
	//****//
		
		List <WebElement> countries=driver.findElements(By.xpath("//*[@name=\"country_id\"]/option"));
		System.out.println("coption"+ countries.size());
		
		
		for(WebElement country:countries) {
			if(country.getText().equals("India")) {
				country.click();

				System.out.println(country.getText());
				break;
			}
		}
	}

}
