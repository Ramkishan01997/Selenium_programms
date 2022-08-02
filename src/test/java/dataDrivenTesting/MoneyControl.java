package dataDrivenTesting;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MoneyControl {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
		
		
		String file="C:\\Users\\ramkishan\\Desktop\\LoginData.xlsx";
		int row=XlUtils.getRowCount(file,"Sheet2");
		for (int i=1;i<=row;i++) {
			String pric=XlUtils.getCellData(file, "Sheet2", i, 0);
			String rateofinterest=XlUtils.getCellData(file, "Sheet2", i, 1);
			String per1=XlUtils.getCellData(file, "Sheet2", i, 2);
			String per2=XlUtils.getCellData(file, "Sheet2", i, 3);
			String fre=XlUtils.getCellData(file, "Sheet1", i, 4);
			String exp_mvalue=XlUtils.getCellData(file, "Sheet2", i,5);
			System.out.println(fre);
			
			driver.findElement(By.xpath("//*[@name='principal']")).sendKeys(pric);
			driver.findElement(By.xpath("//*[@name='interest']")).sendKeys(rateofinterest);
			driver.findElement(By.xpath("//*[@name='tenure']")).sendKeys(per1);
			WebElement days=driver.findElement(By.xpath("//*[@name='tenurePeriod']"));
			Select perdrp=new Select(driver.findElement(By.xpath("//select[@id='tenurePeriod']")));
			perdrp.selectByVisibleText(per2);
			System.out.println(fre);
			Thread.sleep(3000);
//			Select fredrp=new Select(driver.findElement(By.xpath("//select[@id='frequency']")));
//			fredrp.selectByVisibleText(fre);
			Thread.sleep(3000);
			WebElement calculate=driver.findElement(By.xpath("//div[@class='CTR PT15']//a[1]"));
			
			JavascriptExecutor  js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", calculate);
			
		
			String act_result=driver.findElement(By.xpath("//span[@id='resp_matval']/strong")).getText();
			if(Double.parseDouble(act_result)==Double.parseDouble(exp_mvalue)) {
				System.out.println("test Passed");
				XlUtils.setCellData(file, "Sheet2", i, 7, "Pass");
				XlUtils.fillGreenColor(file, "Sheet2", i,7);
			}else {
				XlUtils.setCellData(file, "Sheet2", i, 7, "Fail");
				XlUtils.fillRedColor(file, "Sheet2", i, 7);
			}
			
		WebElement clear=driver.findElement(By.xpath("//div[@class='CTR PT15']//a[2]"));
		js.executeScript("arguments[0].click();", clear);
		Thread.sleep(3000);
		
		}
		String exp_mvalue1=XlUtils.getCellData(file, "Sheet2", row-1,5);
		System.out.println(exp_mvalue1);
	}

}
