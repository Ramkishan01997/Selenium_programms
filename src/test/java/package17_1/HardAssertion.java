package package17_1;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardAssertion {

	
	/*@Test
	void assertionTest() {
		int a=2;
		int b=3;
		
		if(a<b) {
			Assert.assertTrue(true);
			System.out.println(" Assertion passed");
		}else {
			Assert.assertTrue(false);
			System.out.println(" Assertion failed");
		}
		
		Assert.assertEquals(a>b, true,"comparison assertion");
	}
	*/
	@Test(priority=1)
	void hardassert() {
		Assert.assertEquals(2, 4);
	}
	
	@Test(priority=2)
	void softassertion() {
		int a=2;
		int b=4;
	 SoftAssert as=new SoftAssert();
	 
	 as.assertEquals(a,b);
//	 as.assertAll();
		
	}
	
	@Test(priority=3,dependsOnMethods= {"hardassert"})
	void depend() {
		System.out.println("running dependent method");
		
	}
	
	
}
