package testNGXtentReportGeneration;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class ListenersClass implements ITestListener{
	
	@Override
	public void onStart(ITestContext context) {
		System.out.println("Test execution started....");
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test started");
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test passed");
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test failed");
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test skipped");
	}
	
	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Test execution completed");
	}

}
