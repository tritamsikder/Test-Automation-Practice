package testNG_Basics;

import org.testng.annotations.Test;

public class Basics {
  @Test (priority = 1)
  public void openApp() {
	  System.out.println("Opening Application.....");
  }
  
  @Test (priority = 2)
  void login() {
	  System.out.println("Login done.......");
  }
  
  @Test (priority = 3)
  void logout() {
	  System.out.println("Logged out.......");
  }
}
