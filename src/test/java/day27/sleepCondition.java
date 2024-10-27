package day27;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class sleepCondition {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
    // Adding Thread.sleep for element is to get fully loaded in page
		Thread.sleep(5000);
		WebElement txtUsername= driver.findElement(By.xpath("//*[@name=\"username\"]"));
		txtUsername.sendKeys("admin");

	}

}
