package package18;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataprovider {

	@BeforeClass
	void setup() {
		System.out.println(" this is seetup method");
	}

	@Test(dataProvider = "value")
	void login(String name, String email,String val) {

		System.out.println(name);
		System.out.println(email);
		System.out.println(val);
	}

	@DataProvider(name = "value", indices = { 0, 2 }) // indices used to run only particular values
	String[][] dataprovider() {
		String data[][] = { { "ramkishan", "123456","ooooo" }, { "tyhnjj", "5222" ,"kokkk"}, { "yguhbhjb", "jnjn","njikjnkn" } };
		return data;
	}

	@AfterClass
	void after() {
		System.out.println(" after class method");
	}

}
