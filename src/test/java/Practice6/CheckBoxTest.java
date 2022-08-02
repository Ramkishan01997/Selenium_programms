package Practice6;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBoxTest {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://itera-qa.azurewebsites.net/home/automation");
		
		List <WebElement> checkBoxOptions=driver.findElements(By.xpath("//*[@class=\"custom-select\"]/option"));
		System.out.println(checkBoxOptions.size());
		
		for(int i=0;i<checkBoxOptions.size();i++) {
			System.out.println(checkBoxOptions.get(i).getText());
			if(checkBoxOptions.get(i).getText().equals("Spain")) {
				checkBoxOptions.get(i).click();
				break;
			}
		}
		for(WebElement chk:checkBoxOptions) {
			System.out.println(chk.getText());
		}
		
		List <WebElement> Courses=driver.findElements(By.xpath("//*[@class=\"custom-control-input\" and @type=\"checkbox\"]"));
		
		for(WebElement co:Courses) {
			System.out.println(co.getText());
//			co.click();
		}
	}

}
