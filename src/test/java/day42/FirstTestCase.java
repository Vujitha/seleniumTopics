package day42;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FirstTestCase {
	WebDriver driver;
	@Test(priority=1)
	public void openApp() 
	{
	     driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
	}
   @Test(priority=2)
	public void testLogo() throws InterruptedException
	{
	   Thread.sleep(3000);
		System.out.println(driver.findElement(By.xpath("//img[@alt=\"company-branding\"]")).isDisplayed());
	}
   @Test(priority=3)
   void testLogin()
   {
	   driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("Admin");
	   driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("admin123");
	   driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
   }
   @Test (priority=4)
   void closeApp()
   {
	   driver.quit();
   }
}
