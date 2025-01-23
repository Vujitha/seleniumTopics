package day46;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Listeners(day46.MyListener.class)
public class OrangeHRM {
	
	WebDriver driver;
	String URL ="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	
	@BeforeClass
	void setUp() throws InterruptedException
	{
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
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
		Assert.assertEquals(title, "OrangeHRMS");
	}
	@Test (priority =3,dependsOnMethods= {"testTitle"})
	void testURL()
	{
		Assert.assertEquals(driver.getCurrentUrl(), "URL");
	}
	@AfterClass
	void tearDown()
	{
		driver.quit();
	}


}
