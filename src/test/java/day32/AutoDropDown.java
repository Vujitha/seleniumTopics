package day32;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoDropDown {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//*[@title=\"Search\"]")).sendKeys("sele");
		List<WebElement> listOfElements = driver.findElements(By.xpath("//*[@id=\"Alh6id\"]//ul//li"));
		int size = driver.findElements(By.xpath("//*[@id=\"Alh6id\"]//ul//li")).size();
		
		for(WebElement eachElement:listOfElements) 
		{
			String searchElement = eachElement.getText();
			if(searchElement.equals("selenium")) 
			{
				eachElement.click();
				System.out.println(driver.getTitle());
				break;
			}
			
		}
		driver.close();
	}
      
}
