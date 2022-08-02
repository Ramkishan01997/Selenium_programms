package practice9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");

		int row = driver.findElements(By.xpath("//*[@name=\"BookTable\"]//tr")).size();
		int col = driver.findElements(By.xpath("//*[@name=\"BookTable\"]//th")).size();

		System.out.println("no of rows : " + row);
		System.out.println("no of col : " + col);

//	for(int i=1;i<row;i++) {
//		String value=driver.findElement(By.xpath("//*[@name=\"BookTable\"]//tr["+i+"]")).getText();
//		System.out.println(value);
//	}
		
	///****//
		for(int i=2;i<row;i++) {
			for(int c=1; c<col;c++) {
			String value=driver.findElement(By.xpath("//*[@name=\"BookTable\"]//tr["+i+"]/td["+c+"]")).getText();
			System.out.println(value+ " ");
		}}
		int total=0;
		//***find sum of price of all book
		for(int i=2;i<=row;i++) {
			
			String price=driver.findElement(By.xpath("//*[@name=\"BookTable\"]//tr["+i+"]/td[4]")).getText();
			
			total=total+Integer.parseInt(price);
			System.out.println("sum of tottal of all books is "+total);
		}
	}

}
