package package18;

import org.testng.annotations.Test;

public class GroupingTests {

	@Test(priority=1,groups= {"sanity","regression"})
	void loginbymail() {
		System.out.println(" Login by email ID");
	}

	@Test(priority=2,groups= {"sanity","regression"})
	void loginbyfacebook() {
		System.out.println(" Login by facebook");
	}

	@Test(priority=3,groups= {"sanity","regression"})
	void loginbygoogle() {
		System.out.println(" login by google");
	}

	@Test(priority=4,groups= {"sanity","regression"})
	void signupbyemail() {
		System.out.println(" signup by email");
	}

	@Test(priority=5,groups= {"sanity","regression"})
	void signupbyfacebook() {
		System.out.println(" signup by  facebook");
	}

	@Test(priority=6,groups= {"regression"})
	void signup_by_google() {
		System.out.println(" signup by google");
	}

	@Test(priority=7,groups= {"sanity"})
	void sendmoney() {
		System.out.println(" send money");
	}

	@Test(priority=8,groups= {"sanity"})
	void withdraw_amount() {
		System.out.println(" withdraw amount");
	}

	@Test(priority=9,groups= {"regression"})
	void forget_password() {
		System.out.println(" forget password");
	}

}
