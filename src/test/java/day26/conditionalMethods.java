package day26;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class conditionalMethods {

	public static void main(String[] args) {
	
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/register");
		driver.manage().window().maximize();

	//isdisplayed()->Checks the logo is displayed or not
		boolean titleDisplayed = driver.findElement(By.xpath("//h1[text()='Register']")).isDisplayed();
		System.out.println("The landed page Title is:" +titleDisplayed);
		
   //isSelected()->Checks the radio button or checkbox or dropdown's are selected or not
		boolean checkboxNewsLetter = driver.findElement(By.xpath("//input[@id=\"Newsletter\"]")).isSelected();
		System.out.println("The Newsletter checkbox is checked:" +checkboxNewsLetter);
		
  //isEnabled()->Checks the radio button or checkbox or dropdown's or buttons are enabled or not
		//driver.findElement(By.xpath("//input[@id=\"gender-female\"]")).click();
		boolean femaleRadio_bt = driver.findElement(By.xpath("//input[@id=\"gender-female\"]")).isSelected();
		System.out.println("The female radio buttons is selected:" +femaleRadio_bt);
		
/*		if(femaleRadio_bt)
		{
		System.out.println("The female radio buttons is selected:" +femaleRadio_bt);
		}
		else
		{
			System.out.println("Radio button is not selected:" +femaleRadio_bt);
		} */
		//driver.close();
	}

}
