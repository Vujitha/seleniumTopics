package day35;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Datepickers {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();
		
		String month = "May";
		String date  = "5";
		String year = "2025";
		
		driver.switchTo().frame(0); // Switching to dateselector frame
		driver.findElement(By.className("hasDatepicker")).click(); // clicks on date field

// Selecting month and year
		while(true)
        {
			String monthInCalender = driver.findElement(By.xpath("//span[@class=\"ui-datepicker-month\"]")).getText();
			String yearInCalender  = driver.findElement(By.xpath("//span[@class=\"ui-datepicker-year\"]")).getText();
			if(monthInCalender.equals(month)&& yearInCalender.equals(year)) 
			{
				break;
			}
			driver.findElement(By.xpath("//a[@title=\"Next\"]")).click();
		}
// Selecting date
       int dateSize = driver.findElements(By.xpath("//a[@class=\"ui-state-default\"]")).size();
       for(int i=0; i<=dateSize; i++)
       {
    	   String dateIncalneder = driver.findElements(By.xpath("//a[@class=\"ui-state-default\"]")).get(i).getText();
    	   if(dateIncalneder.equals(date)) 
    	   {
    		   driver.findElements(By.xpath("//a[@class=\"ui-state-default\"]")).get(i).click();
    		   break;
    	   }
       }
		
	}

}
