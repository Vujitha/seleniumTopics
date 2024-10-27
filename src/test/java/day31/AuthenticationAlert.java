package day31;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthenticationAlert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		        WebDriver driver = new ChromeDriver();
	/*	        syntax
		        https://username:password@the-internet.herokuapp.com/basic_auth 
		       */
				driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
				driver.manage().window().maximize();
				
	}

}
