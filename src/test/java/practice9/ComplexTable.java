package practice9;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ComplexTable {

	public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.get("https://demo.opencart.com/admin/index.php");
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.findElement(By.name("username")).clear();
	driver.findElement(By.name("username")).sendKeys("demo");
	
	driver.findElement(By.name("password")).clear();
	driver.findElement(By.name("password")).sendKeys("demo");

	driver.findElement(By.xpath("//*[@type=\"submit\"]")).click();
	
	
	if(driver.findElement(By.xpath("//*[@class=\"btn-close\"]")).isDisplayed())
	{
		driver.findElement(By.xpath("//*[@class=\"btn-close\"]")).click();
		}
	
	
	driver.findElement(By.xpath("//a[@class='parent collapsed'][normalize-space()='Customers']")).click();
	driver.findElement(By.xpath("//ul[@class='collapse show']/li[1]")).click();
	
	String text=driver.findElement(By.xpath("//*[@class='col-sm-6 text-end']")).getText();
	//int total=Integer.parseInt(text.substring(text.indexOf("(")+1,text.indexOf("Pages")-1));
	int total=Integer.parseInt(text.substring(text.indexOf("(")+1,text.indexOf("Pages")-1));
	System.out.println(text);
	System.out.println(total);
	int row=driver.findElements(By.xpath("//*[@class='table-responsive']//tr")).size();
	int col=driver.findElements(By.xpath("//*[@class='table-responsive']//tr[2]/td")).size();
//	for(int i=1;i<=row;i++) {
//		for(int j=1;j<=col;j++) {
//			String val=driver.findElement(By.xpath("//*[@class='table-responsive']//tr["+i+"]/td["+j+"]")).getText();
//			
//			System.out.println(val+ " ");
//		}
//	}
	
	for(int i=1;i<=5;i++) {
		WebElement act_page=driver.findElement(By.xpath("\"//ul[@class='pagination']//li//*[text()=\"+p+\"]\""));
		act_page.click();	}
	
	}

}
