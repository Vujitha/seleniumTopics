package day27;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class implicitCondition {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
    /* Implicit wait will be applicable for each and every element and once the element is 
		avaliable in page it will move to next element without waiting full mentioned time.		*/
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
   
		WebElement txtUsername= driver.findElement(By.xpath("//*[@name=\"username\"]"));
		txtUsername.sendKeys("admin");

	}

}
