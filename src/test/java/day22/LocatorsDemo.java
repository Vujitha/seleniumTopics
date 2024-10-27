package day22;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dataProvider.DataProvider;
import dataProvider.DataProvider1;
public class LocatorsDemo {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/login/");
		
/*		WebElement searchBox = driver.findElement(By.name("search"));
	    searchBox.sendKeys(DataProvider1.enterSearchData); */
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
// Iterate over the search data
        for (String searchTerm : DataProvider1.searchData) {
// Find the search box element
            WebElement userName = driver.findElement(By.name("email"));
            userName.clear(); // Clear the search box before entering new data
            
// Enter the current search term
            userName.sendKeys(searchTerm);
            
// Find and click the search button
            WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
            loginButton.click();
            //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".product-layout")));
            System.out.println("Entered first data");
        }

	    

	}

}
