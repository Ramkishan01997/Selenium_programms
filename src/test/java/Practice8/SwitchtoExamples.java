package Practice8;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwitchtoExamples {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
//		driver.get("https://testautomationpractice.blogspot.com/");
//	
//	driver.findElement(By.xpath("//*[@id=\"Wikipedia1_wikipedia-search-input\"]")).sendKeys("selenium");
//	driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
//	List<WebElement> links=driver.findElements(By.xpath("//*[@id=\"wikipedia-search-result-link\"]/a"));
//	System.out.println(links.size());
//	for(WebElement link:links) {
//		link.click();
//		System.out.println(link);
//	}
//	for(int i=0;i<links.size();i++) {
//		links.get(i).click();
//		System.out.println(links.get(i).getText());
//	}
//	System.out.println("printing & clicking links................");
//	for(WebElement link:links)
//	{
//		System.out.println(link.getText());
//		link.click();
//	}
	driver.get("https://testautomationpractice.blogspot.com/");
	
	driver.findElement(By.xpath("//input[@id='Wikipedia1_wikipedia-search-input']")).sendKeys("testing");
	driver.findElement(By.xpath("//input[@type='submit']")).click();
	
	List<WebElement> searchlinks=driver.findElements(By.xpath("//div[@id='Wikipedia1_wikipedia-search-results']//div/a"));
	
	System.out.println("Number of Links:"+ searchlinks.size());
	
	System.out.println("printing & clicking links................");
	for(WebElement link:searchlinks)
	{
		System.out.println(link.getText());
		link.click();
	}
	
	//After opening all the pages, capture windowid's
	Set<String> windowIds=driver.getWindowHandles();
	
	System.out.println("Switching to each browser window and getting the titles........"); 
	for(String winid:windowIds)
	{
		String title=driver.switchTo().window(winid).getTitle();
		System.out.println(title);
	}
	
	driver.quit();
	
	
	}

}
