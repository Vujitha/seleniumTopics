package day33;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://blazedemo.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//*[@value=\"Find Flights\"]")).click();
		
	   // Getting the no.of rows 
		int rows = driver.findElements(By.xpath("//tbody//tr")).size();
		System.out.println("No.of Rows: "+rows);
		
		//6 - capture prices then store in array
		   String[] pricearr = new String[rows];
				for(int r=1;r<=rows; r++) 
				{
					String price = driver.findElement(By.xpath("//tbody//tr["+r+"]//td[6]")).getText();
					pricearr[r-1] =price;
				}
	 //7- Sorting the array inorder to find the lowest price the array will be sorted in ascending order
				Arrays.sort(pricearr);
				String lowsetPrice = pricearr[0];
				
	//8- Find record in table having lower price
				for(int r=1;r<=rows; r++) 
				{
					String price = driver.findElement(By.xpath("//tbody//tr["+r+"]//td[6]")).getText();
					
					if(price.equals(lowsetPrice)) 
					{
						driver.findElement(By.xpath("//tbody//tr["+r+"]//td[1]")).click();
						break;
					}
				}
				
				boolean titleDisplayed = driver.findElement(By.tagName("h2")).isDisplayed();
				System.out.println("The Title is displayed: " +titleDisplayed);
				//New code
	}

}
