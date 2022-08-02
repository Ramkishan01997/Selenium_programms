package package17_1;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Annotation {

	@BeforeMethod
	void login() {
		System.out.println(" login...");
	}
	@Test
	void search() {
		System.out.println(" searching..");
	}
	
	@Test
	void advanceSearch() {
		System.out.println(" advance search");
	}
	@AfterMethod
	void logout() {
		System.out.println(" logout...");
	}
	
	
	
	
	
}
