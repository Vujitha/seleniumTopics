package day29;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeWindowHandles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.className("wikipedia-search-input")).sendKeys("selenium");
		driver.findElement(By.className("wikipedia-search-button")).click();
		List<WebElement> links = driver.findElements(By.xpath("//div[@id=\"wikipedia-search-result-link\"]//a"));
		int linkCount = links.size();
		
		for(int i=0; i<linkCount; i++)
		{
			links.get(i).click();
			
		}
		Set<String> windowIds = driver.getWindowHandles();
		for(String winIds: windowIds) 
		{
			String title = driver.switchTo().window(winIds).getTitle();
			System.out.println("The title is:" +driver.getTitle());
			if(title.equals("Selenium - Wikipedia")||title.equals("Selenium in biology - Wikipedia")||title.equals("Selenium (software) - Wikipedia")||title.equals("Selenium disulfide - Wikipedia")||title.equals("Selenium dioxide - Wikipedia"))
			{
				System.out.println("For Loop title is:" +driver.getTitle());
				driver.close();
			}
		}
		
	}

	

}
