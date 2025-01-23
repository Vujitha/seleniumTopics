package day45;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParamTest {

	WebDriver driver;
//	String URL ="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	
	@BeforeClass
	@Parameters({"browser","url"})
	void setUp(String br, String url) throws InterruptedException
	{
		switch(br.toLowerCase())
		{
		case "chrome": driver = new ChromeDriver();break;
		case "edge"  : driver = new EdgeDriver();break;
		case "firefox": driver = new FirefoxDriver();break;
		default: System.out.println("Invalid browser");return;
		}
// return is completely getting out of method if browser is invalid the other code will not execute.
// break only come out of switch case.
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}
	@Test (priority =1)
	void testLogo()
	{
		boolean status = driver.findElement(By.xpath("//img[@alt=\"company-branding\"]")).isDisplayed();
		Assert.assertEquals(status, true);
	}
	@Test (priority =2)
	void testTitle()
	{
		String title = driver.getTitle();
		Assert.assertEquals(title, "OrangeHRM");
	}
	@Parameters({"url"})
	@Test (priority =3)
	void testURL(String url)
	{
		Assert.assertEquals(driver.getCurrentUrl(), url);
	}
	@AfterClass
	void tearDown()
	{
		driver.quit();
	}
}
