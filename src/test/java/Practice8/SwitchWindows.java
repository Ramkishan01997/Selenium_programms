package Practice8;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwitchWindows {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
       
		driver.findElement(By.xpath("//*[@id=\"social-icons\"]/a[2]")).click();
	// 1st approach************
	
//		Set<String> windows=driver.getWindowHandles();
//	
//		
//		for(String winId:windows) {
//			String title=driver.switchTo().window(winId).getTitle();
//			if(title.equals("OrangeHRM")) {
//				driver.close();
//			}
//			System.out.println(driver.getTitle());
//			//OrangeHRM
//			//OrangeHRM - World's Most Popular Opensource HRIS - Home | Facebook
//		}
	//*********end
		//**2nd approach
		
		Set<String> windows=driver.getWindowHandles();
		List<String> winid=new ArrayList(windows);
		
		String parent=winid.get(0);
		String child=winid.get(1);
		
		System.out.println(parent+ "   "+child);
		driver.switchTo().window(child);
		System.out.println(driver.getTitle());
		driver.close();
		
	
	}

}
