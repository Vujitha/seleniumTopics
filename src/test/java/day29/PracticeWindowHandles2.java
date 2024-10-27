package day29;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeWindowHandles2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.className("wikipedia-search-input")).sendKeys("selenium");
		driver.findElement(By.className("wikipedia-search-button")).click();
		List<WebElement> searchlinks = driver.findElements(By.xpath("//div[@id=\"wikipedia-search-result-link\"]//a"));
		
		System.out.println("Number of Links:" +searchlinks.size());
		
		System.out.println("printing & clciking links.......");
		for(WebElement link:searchlinks)
		{
			System.out.println(link.getText());
			link.click();
		}
		
// After opening all the pages, capture windowid's
		Set<String> windowIds = driver.getWindowHandles();
		System.out.println("Switching to each browser window and getting the titles.......");
		for(String winIds: windowIds) 
		{
          String title = driver.switchTo().window(winIds).getTitle();
		  System.out.println(title);
		}
		driver.quit();
	}

}
