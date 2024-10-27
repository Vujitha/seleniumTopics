package day24;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class xPathDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/login/");
		driver.manage().window().maximize();
		
/*	//xPath with multiple attributes
		driver.findElement(By.xpath("//*[@name=\"email\"] [@id=\"email\"]")).sendKeys("jack");
		
	//xPath with and, OR operators //*[@name="email"and @id="email"]
		driver.findElement(By.xpath("//*[@name=\"email\"and @id=\"email\"]")).sendKeys("jack"); // both attributes should be true then only it will locate element
		driver.findElement(By.xpath("//*[@name=\"email\"or @id=\"email\"]")).sendKeys("jack"); // atleast 1 attribute should be true then only it will locate element
   */
	//xpath using inner text using text() method //div[text()="Log in to Facebook"]
		boolean displaystatus= driver.findElement(By.xpath("//div[text()=\"Log in to Facebook\"]")).isDisplayed();
		System.out.println(displaystatus);
		
		String text = driver.findElement(By.xpath("//div[text()=\"Log in to Facebook\"]")).getText();
		System.out.println(text);
		if(text.equals("Log in to Facebook"))
		{
			System.out.println("Test Passed");
		}
		else
		{
			System.out.println("Test Failed");
		}
		//driver.findElement(By.xpath("//*[text()=\"Sign up for Facebook\"]")).click();
	
	//xPath with contains(verifies the partial value of attribute)
		driver.findElement(By.xpath("//input[contains(@class,'inputtext')]")).sendKeys("jack");
	
	//xPath with starts-with()
		driver.findElement(By.xpath("//input[starts-with(@class,'inputtext')]")).sendKeys("jack");
		
	//Child xpath
		driver.findElement(By.xpath("//div[@id='logo']/a/img"));
	}
	

}
