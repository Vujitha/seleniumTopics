package day26;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class getMethods {

	public static void main(String[] args) {
		
        WebDriver driver = new ChromeDriver();
		
      //get() open the url on the browser
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        
	  //getTitle()-> returns title of the page
		System.out.println(driver.getTitle());
	
	 //getCurrentUrl()-> returns url of the page
		System.out.println(driver.getCurrentUrl());
		
    //getPageSource()-> return source code of the page
		//System.out.println(driver.getPageSource());
	
	//getWindowHandle()-> return the ID of single browser window
		System.out.println(driver.getWindowHandle());
		
	//getWindowHandles() -> returns Id's of multiple browser windows
		driver.findElement(By.xpath("//a[text()='Limited offer - FREE Core Java & QA Resume course']")).click();
		Set<String> browserWindows = driver.getWindowHandles();
		System.out.println("Browsers :"+browserWindows);
   
	}

}
