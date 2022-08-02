package package17;

//import org.testng.annotations.AfterMethod;
import org.testng.annotations.*;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;

public class Test1 {
	
	
	@Test
	void testA() {
		System.out.println(" this is test a");
	}
	@Test
	void testB() {
		System.out.println("this is test B");
	}
	@BeforeTest
	void beforeTest() {
		System.out.println("Before Test ....");
	}
	@AfterTest
	void afterTest() {
		System.out.println(" this is after Test...");
	}
	@BeforeMethod
	void beforeMethod() {
		System.out.println(" before method...");
	}
	@AfterMethod
	void aftermethod() {
		System.out.println(" after method...");
	}
	@BeforeClass
	void beforeclass() {
		System.out.println("Before class. .....class");
	}
	@AfterClass
	void afterclass() {
		System.out.println("After class........class");
	}

}
