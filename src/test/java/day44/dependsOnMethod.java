package day44;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


// Dependencies override the priority, it will always checks dependencies first even though priority is provided
public class dependsOnMethod {

	@Test (priority=2)
	void login()
	{
		Assert.assertTrue(true); 
		System.out.println("I am in Login page....");
	
	}
   @Test (priority=1)
   void search() 
   {
	    System.out.println("Performing search....");
	   
   }
   @Test (priority=3,dependsOnMethods= {"search"})
   void advSearch()
   {
	   Assert.assertTrue(true);
	   System.out.println("performing advSearch....");
   }

}
