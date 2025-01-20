package day34;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignement_1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		int pageSize = driver.findElements(By.xpath("//ul[@class=\"pagination\"]//li")).size();
		System.out.println("No.of pages: " +pageSize);
//Repeating pages
	 for(int p=1; p<=pageSize; p++)
	 {
		 if(p>1) 
		 {
			 driver.findElement(By.xpath("//ul[@class=\"pagination\"]//li["+p+"]")).click(); 
			 Thread.sleep(3000);
		 }
		 //Reading data from the page
		 int noOfRows = driver.findElements(By.xpath("//table[@id=\"productTable\"]//tr")).size();
		 System.out.println("Total No of Rows:" +noOfRows);
		 for(int r=1; r<=noOfRows; r++)
		 {
			 String Name = driver.findElement(By.xpath("//table[@id=\"productTable\"]//tbody//tr["+r+"]/td[2]")).getText();
			 String price = driver.findElement(By.xpath("//table[@id=\"productTable\"]//tbody//tr["+r+"]/td[3]")).getText();
			 System.out.println(Name+ "\t"+price);
			 WebElement checkbox = driver.findElement(By.xpath("//table[@id=\"productTable\"]//tr["+r+"]//td[3]"));
			 checkbox.click();
			System.out.println(driver.findElement(By.xpath("//table[@id=\\\"productTable\\\"]//tr[\"+r+\"]//td[3]")).isSelected()); driver.findElement(By.xpath("//table[@id=\\\"productTable\\\"]//tr[\"+r+\"]//td[3]")).isSelected();
		 }
	
	 }
	
	}

}
