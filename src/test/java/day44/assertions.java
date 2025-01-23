package day44;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


/* Hard Assertions: Once the condition is failed the next lines of code in a method will not execute.
 *                  Assert class is used for Hard assertions we can directly call methods using class Assert has methods are static.
 * Soft Assertions: Even the condition is failed the next lines of code in a method will execute.
 *                  We need to create object for soft Assertions.
 * Methods are same for both Hard and Soft assertions but the way of calling will differ.
 * Assertions:
 * Assert.assertTrue();
 * Assert.assertEquals();
 * Assert.assertNotEquals();
 */
public class assertions {
	
	@Test (priority=1)
	void login()
	{
		Assert.assertTrue(false); // Used Hard assertion so next lines of code will not execute for this method.
		System.out.println("I am in Login page....");
	
	}
   @Test (priority=2)
   void search() 
   {
	   SoftAssert as = new SoftAssert();
	   as.assertTrue(false);
	   as.assertAll(); // This method is must and should if not even though the condition is failed the method will show as passed in console.
	   System.out.println("Performing search....");
	   
   }
   @Test (priority=3)
   void advSearch()
   {
	   Assert.assertTrue(true);
	   System.out.println("performing advSearch....");
   }
}
