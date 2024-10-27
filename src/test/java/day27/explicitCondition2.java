package day27;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class explicitCondition2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
    /*  Explicit wait declaration and can be used multiple times wherever needed, it will check condition first
     * then returns WebElement if condition is not satisfied it will wait till mentioned time	*/
		
		WebDriverWait myWait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		WebElement txtUsername = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name=\"username\"]")));
		txtUsername.sendKeys("admin");

	}

}
