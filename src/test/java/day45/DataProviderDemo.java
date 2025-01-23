package day45;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {
	
	WebDriver driver;
    @BeforeClass
	void setUp() 
	{
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
    @Test(dataProvider = "dp")
    void testLogin(String email, String password) throws InterruptedException
    {
    	driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
    	driver.manage().window().maximize();
    	driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys(email);
    	driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys(password);
    	driver.findElement(By.xpath("//input[@value=\"Login\"]")).click();
    	Thread.sleep(2000);
    	boolean status = driver.findElement(By.xpath("//h2[text()=\"My Account\"]")).isDisplayed();
    	if(status == true)
    	{
    		driver.findElement(By.xpath("//a[@title=\"My Account\"]")).click();
    		driver.findElement(By.xpath("//li/a[text()=\"Logout\"]")).click();
    		Assert.assertTrue(true);
    	}
    	else
    		Assert.fail();
    }
    @AfterClass
    void tearDown()
    {
    	driver.close();
    }
/* Data provider always returns data in 2 dimensional array
   Indices is used when we don't want to run whole data instead running selected data like only 0,4 0r 1,2,3 likewise
 */
    @DataProvider(name="dp", indices= {0,1})
    Object[][] loginData()
    {
    	Object data[][] = {
    			            {"john123402@gmail.com", "FBpGH@67WQy6GS"},
    			            {"yashna890@gmail.com",  "yashna890@gmail.com"},
    			            {"virat678@gmail.com",  "virat678@gmail.com"},
    			            {"sadsfd@gmail.com",  "123444"},
    	                  };
    	return data;
    }
    
}

