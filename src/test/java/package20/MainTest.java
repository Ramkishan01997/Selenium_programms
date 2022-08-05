package package20;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MainTest {
	
	
	@Test(priority=1)
	void test1() {
		System.out.println(" this is test 1");
		Assert.assertEquals("a","a");
	}
	
	@Test(priority=2)
	void test2() {
		System.out.println(" Test 2");
		Assert.assertEquals("A", "B");
	}
	@Test(priority=3,dependsOnMethods= {"test1"})
	void test3() {
		System.out.println(" this is test 3");
	}
	
	

}
