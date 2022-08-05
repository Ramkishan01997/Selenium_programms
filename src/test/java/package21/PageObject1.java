package package21;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageObject1 {
	WebDriver driver;
	
	
	public PageObject1(WebDriver driver) {
		this.driver=driver;
	}
	
	By logo_txt=By.xpath("//*[@id='divLogo']/img");
	
	By user_name_txt=By.xpath("//input[@id='txtUsername']");
	
	By pass_txt=By.xpath("//input[@id='txtPassword']");
	
	By login_btn=By.id("btnLogin");
	
	//OrangeHRM
	By logout_main=By.xpath("//*[@id='welcome']");
	
	By logout_btn=By.xpath("//*[@id='welcome-menu']//li[3]");
	
	
	public boolean check_logo_presence() {
		boolean Status=driver.findElement(logo_txt).isDisplayed();
		return Status;
	}
	
	public void setUserName(String uname) {
		driver.findElement(user_name_txt).sendKeys(uname);
	}
	public void setPassWord(String pass) {
		driver.findElement(pass_txt).sendKeys(pass);
	}
	public void clickLogin() {
		driver.findElement(login_btn).click();
	}
	
	public void clickLogoutdrp() {
		driver.findElement(logout_main).click();	}
	    
	public void logout() {
		driver.findElement(logout_btn).click();
	}

	
}
