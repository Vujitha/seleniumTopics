package day43;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class c1 {
	
	@BeforeTest
	 public void bm() 
	  {
		  System.out.println("This is BeforeTest....");
		  
	  }
	@Test(priority=2)
	 public void A2() 
	  {
		  System.out.println("Add application....");
		  
	  }
	@Test (priority=3)
	 public void A3() 
	  {
		  System.out.println("Nothing to say....");
		  
	  }
	@AfterTest
	 public void am() 
	  {
		  System.out.println("This is AfterTest....");
		  
	  }
}
