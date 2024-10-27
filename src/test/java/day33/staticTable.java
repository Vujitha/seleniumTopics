package day33;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class staticTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();

		// find total number of rows in a table
		int rows = driver.findElements(By.xpath("//table[@name=\"BookTable\"]//tr")).size();
		System.out.println("No.of Rows: "+rows);
		
		// find total number of columns in a table
		int columns = driver.findElements(By.xpath("//table[@name=\"BookTable\"]//tr//th")).size();
		System.out.println("No.of columns: "+columns);
	// Read data from all the Rows and columns
		System.out.println("BookName"+"\t"+"Author"+"\t"+"Subject"+"\t"+"Price");
/*		for(int r=2; r<=rows; r++) 
		{
		    for(int c=1; c<=columns; c++) 
		    {
		    	String value = driver.findElement(By.xpath("//table[@name=\"BookTable\"]//tr["+r+"]//td["+c+"]")).getText();
		    	System.out.println(value+"\t");
		    }
		    System.out.println();
		}
	*/
	// Want to print the BookName where the Author is Mukesh
		for(int r=2; r<=rows; r++) 
		{
			String authorName = driver.findElement(By.xpath("//table[@name=\"BookTable\"]//tr["+r+"]//td[2]")).getText();
			if(authorName.equals("Mukesh")) 
			{
				String bookName = driver.findElement(By.xpath("//table[@name=\"BookTable\"]//tr["+r+"]//td[1]")).getText();
				System.out.println(bookName+"\t"+authorName);
			}
		}
		int Total =0;
   // Find total price of books
		for(int r=2; r<=rows; r++)
		{
			String price = driver.findElement(By.xpath("//table[@name=\"BookTable\"]//tr["+r+"]//td[4]")).getText();
			Total=Total+Integer.parseInt(price);
			
		}
		System.out.println("The total price of books is: "+Total);
	}

}
