package package17_1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependonMethod {

	
	
	@Test(priority=1)
	void display() {
		System.out.println(" this is display method ");
		Assert.assertTrue(false);
	}
	@Test(priority=2 , dependsOnMethods= {"display"})
	void showMessage() {
		System.out.println(" show messahge");
	}
	
	@Test(priority=3)
	void login() {
		System.out.println(" login method");
	}
	
	@Test(priority=4)
	void addTocart() {
		System.out.println(" add to cart");
	}
	
	@Test(priority=5)
	void logout() {
		System.out.println(" logout");
	}
}
