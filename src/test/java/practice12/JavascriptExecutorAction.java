package practice12;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavascriptExecutorAction {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.switchTo().frame(0);
		WebElement inputBox = driver.findElement(By.xpath("//input[@id='RESULT_TextField-1']"));

		js.executeScript("arguments[0].setAttribute('value','selenium');", inputBox);
		WebElement chk = driver.findElement(By.xpath("//input[@id='RESULT_RadioButton-7_0']"));
		js.executeScript("arguments[0].click();", chk);
		System.out.println(chk.isSelected());
		driver.findElement(By.xpath("//*[text()=\"Monday\"]")).click();
	}

}
