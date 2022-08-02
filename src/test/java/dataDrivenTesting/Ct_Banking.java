package dataDrivenTesting;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ct_Banking {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.cit.com/cit-bank/resources/calculators/certificate-of-deposit-calculator");
		driver.manage().window().maximize();

		String file = "C:\\Users\\ramkishan\\Desktop\\LoginData.xlsx";
		WebElement inDeposit = driver.findElement(By.xpath("//*[@id='mat-input-0']"));

		WebElement lmonths = driver.findElement(By.xpath("//*[@id='mat-input-1']"));

		WebElement interest = driver.findElement(By.xpath("//*[@id='mat-input-2']"));
		WebElement compound = driver.findElement(By.xpath("//*[@class='mat-form-field-flex ng-tns-c101-3']"));

		WebElement runbtn = driver.findElement(By.xpath("//button[@id='CIT-chart-submit']"));

		int rows = XlUtils.getRowCount(file, "Sheet3");

		for (int i = 1; i <= rows; i++) {
			String deposit = XlUtils.getCellData(file, "Sheet3", i, 0);
			String month = XlUtils.getCellData(file, "Sheet3", i, 1);
			String intere = XlUtils.getCellData(file, "Sheet3", i, 2);
			String comp = XlUtils.getCellData(file, "Sheet3", i, 3);
			String exptotal = XlUtils.getCellData(file, "Sheet3", i, 4);
//			System.out.println(deposit + "  " + month + "  " + intere + "   " + comp + " " + expRes + " ");

			inDeposit.clear();
			lmonths.clear();
			interest.clear();
			inDeposit.sendKeys(deposit);
			lmonths.sendKeys(month);
			interest.sendKeys(intere);

			driver.findElement(By.xpath("//mat-select[@id='mat-select-0']")).click();
			List<WebElement> coptions = driver.findElements(By.xpath("//div[@id='mat-select-0-panel']//mat-option"));
			System.out.println(coptions.size());
			for (WebElement li : coptions) {
//				System.out.println(li.getText());
				if (li.getText().equals(comp)) {
					li.click();
				}
			}
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", runbtn);
//		runbtn.click();
			String acttotal = driver.findElement(By.xpath("//span[@id='displayTotalValue']")).getText();
//			System.out.println(actres+" "+expRes);

			if (exptotal.equals(acttotal)) { // if expected total = actual total then

				XlUtils.setCellData(file, "Sheet3", i, 6, "Passed"); // setting passed in 6th column (index start with
																		// zero)
				XlUtils.fillGreenColor(file, "Sheet3", i, 6); // filling the color in 6th column if passed then greeen
																// or faile then red.
			} else {
				XlUtils.setCellData(file, "Sheet3", i, 6, "Failed");
				XlUtils.fillRedColor(file, "Sheet3", i, 6);
			}
		}
//		System.out.println(actres.getText());
		driver.close();
	}

}
