package day29;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleBrowserWindows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
//Clicking on the link where another window will be opened
		driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click();
//Approach 1-> when having 2 windows		
		Set<String> windowIds = driver.getWindowHandles();
		
		List<String> windowList = new ArrayList(windowIds);
		
		String parentId = windowList.get(0);
		String childId = windowList.get(1);
// To get child window title we need to switch to child tab
		driver.switchTo().window(childId);
		System.out.println(driver.getTitle());
		
//Approach 2-> to get multiple window titles or Id's
		for(String winId:windowIds) 
		{
			String title=driver.switchTo().window(winId).getTitle();
			System.out.println("The title is:" +title);
// After getting title we can put the conditions based on our steps by switching to required tab
			if(title.equals("Human Resources Management Software | OrangeHRM")|| title.equals("OrangeHRM")) 
			{
			  driver.close();
				System.out.println("for loop The title is:" +title);
			  System.out.println("Child window is closed");
			}
		}
		
	}

}
