package Practice1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SimpleDemoTest {

	public static void main(String[] args) {
	
		 WebDriverManager.chromedriver().setup();
		 WebDriver driver=new ChromeDriver();
		 
		 driver.get("https://opensource-demo.orangehrmlive.com/");
		
		 driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		 
		 driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		 
		 driver.findElement(By.name("Submit")).click();
		 
		 String act_title=driver.getTitle();
		 String exp_title="OrangeHRM";
		 System.out.println(act_title);
		 if(act_title.equals(exp_title)) {
			System.out.println("Test passed");
		 }else
		 {
			 System.out.println("test failed");
		 }
		 
		 driver.findElement(By.xpath("//*[@id=\"mainMenuFirstLevelUnorderedList\"]/li[3]")).click();
		 
		 
		 String title=driver.findElement(By.xpath("//div[@class=\"head\"]/h1")).getText();
		 
		 String exText="Candidates";
		 if(title.equals(exText)){
			 System.out.println("test 1 passed");
		 }else {
			 System.out.println("test 1fialed");
		 }
	}

}
