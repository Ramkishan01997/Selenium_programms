package Practice6;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBoxDemo {

	public static void main(String[] args) {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://itera-qa.azurewebsites.net/home/automation");
       
		List <WebElement> checkboxes=driver.findElements(By.xpath("//*[@type=\"checkbox\" and @class=\"form-check-input\"]"));
		
//		for(int i=0;i<checkboxes.size();i++) {
//			checkboxes.get(i).click();
//			System.out.println(checkboxes.get(i).getText());
//		}
		for(int i=(checkboxes.size())-2;i<checkboxes.size();i++)
		{
			checkboxes.get(i).click();
		}
		for(WebElement checkbox:checkboxes) {
			if(checkbox.isSelected()) {
			checkbox.click();}
		}
	}

}
