package day46;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener
{
      public ExtentSparkReporter sparkReporter; // UI of the report
      public ExtentReports extent;  // populate common info on the report
      public ExtentTest test;      // creating test case entries in report and update status of test methods
      
      public void onStart(ITestContext context)
      {
    	  sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/myReport.html");
    	  
    	  sparkReporter.config().setDocumentTitle("Automation Report"); //Title of Report
    	  sparkReporter.config().setReportName("Functional Testing");   //name of the Report
    	  sparkReporter.config().setTheme(Theme.DARK); 
    	  
    	  extent = new ExtentReports();
    	  extent.attachReporter(sparkReporter);
    	  
    	  extent.setSystemInfo("Computer Name", "localhost");
    	  extent.setSystemInfo("Environment", "QA");
    	  extent.setSystemInfo("Tester Name", "Vujitha");
    	  extent.setSystemInfo("OS", "Windows10");
    	  extent.setSystemInfo("Browser Name", "Chrome");
    	  
      }
      public void onTestSuccess(ITestResult result) 
      {
    	  test = extent.createTest(result.getName()); // create a new entry in report
    	  test.log(Status.PASS, "Test case passed is:" +result.getName()); // updates status as pass/fail/skipped
      }
      public void onTestFailure(ITestResult result)
      {
    	  test = extent.createTest(result.getName()); 
    	  test.log(Status.FAIL, "Test case failed is:" +result.getName());
    	  test.log(Status.FAIL, "Test case failed is:" +result.getThrowable());
      }
      public void onTestSkipped(ITestResult result)
      {
    	  test = extent.createTest(result.getName()); 
    	  test.log(Status.SKIP, "Test case skipped is:" +result.getName());
      }
      public void onFinish(ITestContext context)
      {
    	  extent.flush();
      }
}
