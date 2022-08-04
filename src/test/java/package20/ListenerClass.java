package package20;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerClass implements ITestListener {
	
	public void onStart(ITestContext context) {
		System.out.println(" onstart method");
	}
	public void onTestStart(ITestResult result) {
		System.out.println(" on Test start");
	}
	public void onTestSuccess(ITestResult result) {
		System.out.println(" on TestSuccess");
	}
	public void onTestFailure(ITestResult result) {
		System.out.println(" on Test Failure");
	}
	public void onTestSkipped(ITestResult result) {
		System.out.println(" on test skipped");
	}
	public void onFinish(ITestResult result) {
		System.out.println(" on Test Finish");
	}

}
