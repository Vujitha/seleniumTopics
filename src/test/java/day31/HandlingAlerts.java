package day31;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingAlerts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		
//NormalAlert
		driver.findElement(By.xpath("//button[@onclick=\"jsAlert()\"]")).click();
		driver.switchTo().alert().accept();
		System.out.println("After Alert ok the success msg:" +driver.findElement(By.xpath("//p[@id=\"result\"]")).getText());
		
//Confirmation Alert
		driver.findElement(By.xpath("//button[@onclick=\"jsConfirm()\"]")).click();
		driver.switchTo().alert().dismiss(); // To cancel
		System.out.println("After cancelling msg:" +driver.findElement(By.xpath("//p[@id=\"result\"]")).getText());

//Prompt Alert
		driver.findElement(By.xpath("//button[@onclick=\"jsPrompt()\"]")).click();
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Testing alert");
		alert.accept(); // To click on OK
	   String result = driver.findElement(By.xpath("//p[@id=\"result\"]")).getText();
	   if(result.contains("Testing")) 
	   {
		   System.out.println("Test passed");
	   }
	   else
	   {
		   System.out.println("Test failed");
	   }
		
	}

}
