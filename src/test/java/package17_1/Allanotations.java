package package17_1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Allanotations {

	@BeforeSuite
	void beforesuite() {
		System.out.println(" before suite......");
	}

	@BeforeTest
	void beforeTest() {
		System.out.println("Before Test...");
	}

	@BeforeClass
	void beforeclass() {
		System.out.println(" before class..");
	}

	@BeforeMethod
	void beforemethod() {
		System.out.println(" before method");
	}

	@Test
	void loginTest() {
		System.out.println(" login test Succefull");
	}

	@AfterMethod
	void afterMethod() {
		System.out.println(" after method");
	}

	@AfterClass
	void afterclass() {
		System.out.println(" After class");
	}
	@AfterTest
	void aftertest() {
		System.out.println(" after test");
	}
	
	@AfterSuite
	void aftersuite() {
		System.out.println(" after suite");
	}

}
