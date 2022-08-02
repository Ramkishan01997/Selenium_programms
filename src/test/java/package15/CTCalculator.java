package package15;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CTCalculator {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.cit.com/cit-bank/resources/calculators/certificate-of-deposit-calculator");
		driver.manage().window().maximize();
		
//		WebElement inDeposit=driver.findElement(By.xpath("///input[@id='mat-input-0']"));
		
		WebElement lmonths=driver.findElement(By.xpath("//*[@id='mat-input-1']"));
		
		WebElement interest=driver.findElement(By.xpath("//*[@id='mat-input-2']"));
		WebElement compound=driver.findElement(By.xpath("//*[@class='mat-form-field-flex ng-tns-c101-3']"));
		
		WebElement runbtn=driver.findElement(By.xpath("//*[@class='mdc-button__ripple']"));
		WebElement actres=driver.findElement(By.xpath("//span[@id='displayTotalValue']"));
		
//		inDeposit.clear();
//		inDeposit.sendKeys("2000");
		lmonths.clear();
		lmonths.sendKeys("3");
		interest.clear();
		interest.sendKeys("4");
		driver.findElement(By.xpath("//*[@class='mat-form-field-flex ng-tns-c101-3']")).click();
		
		
//		List <WebElement> coptions=driver.findElements(By.xpath("mat-select-0-panel"));
//		for(WebElement li:coptions) {
//			System.out.println(li.getText());
//			if(li.getText().equals("Compounded Monthly")) {
//				li.click();
//			}
//		}
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", runbtn);
//		runbtn.click();
		System.out.println(actres.getText());
	}

}
