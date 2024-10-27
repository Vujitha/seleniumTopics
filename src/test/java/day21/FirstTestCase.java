package day21;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTestCase {

	public static int age =10;
	public int nonage =20;
	public static void main(String[] args) {
		
		
	/*	WebDriver driver = new ChromeDriver();
		driver.get("https://demo.opencart.com");
		String act_title = driver.getTitle();
		if(act_title.equals("Your Store"))
		{
			System.out.println("Test Passed");
		}
		else
		{
			System.out.println("Test Failed");
		}
		
		//driver.close(); */
		age =11;
		System.out.println("The age of a person:" +age);
		FirstTestCase TC = new FirstTestCase();
		System.out.println("The age of a person:" +TC.nonage);
	}	

}
