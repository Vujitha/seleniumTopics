package day44;

import org.testng.Assert;
import org.testng.annotations.Test;

public class dependsAnotherExample {

	
	@Test (priority=2)
	void testA()
	{
		 
		System.out.println("Test A");
	
	}
   @Test (priority=1)
   void testB() 
   {
	    System.out.println("Test B");
	   
   }
   @Test (priority=3,dependsOnMethods= {"testB"})
   void testC()
   {
	   System.out.println("Test C");
   }

}
