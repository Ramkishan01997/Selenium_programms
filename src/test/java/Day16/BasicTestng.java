package Day16;

import org.testng.annotations.Test;

public class BasicTestng {
    @Test(priority=1)
	void test1() {
		System.out.println(" running first tetst");
	}
    @Test(priority=2)
	void calculate() {
		System.out.println(" test 2");
	}
    @Test(priority=3)
	void b() {
		System.out.println("test 3");
	}
	
	
}
