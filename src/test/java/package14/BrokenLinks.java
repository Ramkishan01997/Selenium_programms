package package14;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.List;

import org.apache.hc.core5.http.HttpConnection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException  {
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
//
////		driver.get("http://www.deadlinkcity.com/");
//driver.get("https://demo.nopcommerce.com/");
//		List<WebElement> links = driver.findElements(By.tagName("a"));
//		int brokenlist=0;
//		for (WebElement element : links) {
//			String url = element.getAttribute("href");
//			if (url == null && url.isEmpty()) {
//				System.out.println("url is Empty");
//				continue;
//			}
//			URL link = new URL(url);
//try {
//			HttpURLConnection httpconn = (HttpURLConnection) link.openConnection();
//			httpconn.connect();
//			if (httpconn.getResponseCode() >= 400) {
//				System.out.println("brokenlonks list");
//				brokenlist++;
//			}else {
//				System.out.println("not broken List");
//			}
//}
//catch(IOException e) {
//	
//}
//
//		}
//System.out.println("nuber of broken list"+brokenlist);
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	driver.get("http://www.deadlinkcity.com/");
	driver.manage().window().maximize();
	
	List<WebElement> links=driver.findElements(By.tagName("a"));
	
	System.out.println("Total number of link"+links.size());
	
	
	int brokenlinks=0;
	
	for(WebElement element :links)
	{
		String url=element.getAttribute("href");
		
		if(url==null || url.isEmpty())
			{
				System.out.println("URL is empty");
				continue;
			}
	
		URL link=new URL(url);
		
		try 
		{
			HttpURLConnection httpConn = (HttpURLConnection)link.openConnection();
			httpConn.connect();
			
			if(httpConn.getResponseCode()>=400)
			{
				System.out.println("Broken link...");
				brokenlinks++;
			}
			else
			{
				System.out.println("Not Broken link...");
			}
			
		} 
		 catch (MalformedURLException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         } catch (IOException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         }
					
	
	}
	
	System.out.println("Total number of Broken links"+brokenlinks);

	}

}
