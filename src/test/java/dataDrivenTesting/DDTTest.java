package dataDrivenTesting;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DDTTest {
	WebDriver driver;

	@BeforeClass
	void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.cit.com/cit-bank/resources/calculators/certificate-of-deposit-calculator/");
		driver.manage().window().maximize();
		System.out.println("initialized");

	}

	@Test(dataProvider="data")
	void check_interest(String inidepo,String monthlength,String interestrate,String compoundingmonths,String exptotal,String name,String email ) throws InterruptedException {
		WebElement inideposit = driver.findElement(By.xpath("//input[@id='mat-input-0']"));		
		WebElement length = driver.findElement(By.xpath("//input[@id='mat-input-1']"));	
		WebElement apr = driver.findElement(By.xpath("//input[@id='mat-input-2']"));
		WebElement calbutton = driver.findElement(By.xpath("//button[@id='CIT-chart-submit']")); // 'Lets run the numbers' button
		
		
		inideposit.clear();
		length.clear();
		apr.clear();
		Thread.sleep(5000);
		inideposit.sendKeys(inidepo);   //using webelement and passing the values from xl cell data
		length.sendKeys(monthlength);
		apr.sendKeys(interestrate);
		WebElement compoundrp = driver.findElement(By.xpath("//mat-select[@id='mat-select-0']"));   //select class object compounddrp will find elelment by id
		compoundrp.click();
		
		
		String acttotal = driver.findElement(By.xpath("//span[@id='displayTotalValue']")).getText();
		
		System.out.println(" clicked compound");
		List<WebElement> options=driver.findElements(By.xpath("//div[@id='mat-select-0-panel']//mat-option"));
		
		for(WebElement option:options)
		{
			if(option.getText().equals(compoundingmonths))
				option.click();
			System.out.println(" clicked interest");
		}
		
				
		calbutton.click();
		if(exptotal.equals(acttotal)) {	
			Assert.assertTrue(true);
		
		}else {
			Assert.assertTrue(false);
		}
		
	}
	
	
	@DataProvider(name ="data")
	Object[][] getData() throws IOException {

		String file = "C:\\Users\\ramkishan\\Desktop\\LoginData.xlsx";
		int row = XlUtils.getRowCount(file, "Sheet3");
		int col = XlUtils.getCellCount(file, "Sheet3", row);
		String data[][] = new String[row][col];
		for (int i = 1; i <= row; i++) {
			for (int j = 0; j < col; j++) {
				data[i - 1][j] = XlUtils.getCellData(file, "Sheet3", i, j);
			}
		}
		return data;

	}
}
