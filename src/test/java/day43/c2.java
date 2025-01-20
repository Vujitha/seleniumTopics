package day43;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class c2 {
	
	@BeforeSuite
	 public void bs() 
	  {
		  System.out.println("This is BeforeSuite....");
		  
	  }
	@Test (priority=4)
	 public void AC2() 
	  {
		  System.out.println("Add application Ac2....");
		  
	  }
	@Test (priority=1)
	 public void AC3() 
	  {
		  System.out.println("Nothing to say AC3....");
		  
	  }
	@AfterSuite
	 public void as() 
	  {
		  System.out.println("This is AfterSuite....");
		  
	  }
}
