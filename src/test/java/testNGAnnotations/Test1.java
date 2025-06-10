package testNGAnnotations;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterMethod;

public class Test1 {
  @Test
  public void f1() {
	  System.out.println("Method 1....");
  }
  
  @Test
  public void f2() {
	  System.out.println("Method 2....");
  }
  
  @Test
  public void f3() {
	  System.out.println("Method 3....");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("This is before method....");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("This is after method....");
  }
  
  @BeforeTest
  public void beforeTest() {
	  System.out.println("This is before test method....");
  }

}
