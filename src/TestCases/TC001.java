package TestCases;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Reports.Reporter;
import SupportingClass.CommonFunctions;

//@Listeners(Reports.Listeners.class)
public class TC001 extends CommonFunctions {

	Reporter reporter;
	public String path = System.getProperty("user.dir");

	public TC001() {
		System.out.println("default contructor");
		System.setProperty("webdriver.chrome.driver", path + "\\Driver\\chromedriver.exe");
	}

	@BeforeClass
	public void beforeClass() {
		reporter = new Reporter();
		reporter.StartResult(this.getClass().getName());
	}
	
	@AfterClass
	public void afterclass() {
		reporter.EndTest();reporter.FlushResult();
	}
	
	@DataProvider
	public Object[][] dp() {
		return new Object[][] { { "data one" } ,{"data two"}};
	}

	@Test(dataProvider = "dp")
	public void LaunchGoogle(String str) throws IOException {
		WebDriver driver = new ChromeDriver();
		reporter.StartTestCase("LaunchGoogle", str);
		try {

			driver.get("https://www.google.com");
			Explicitwait(driver, "//*[@type='text']");
			driver.manage().window().maximize();
			reporter.TestStepWithScreenshot(driver, "PASS", "Launched Google");
		} catch (Exception e) {
		} finally {
			driver.quit();
			reporter.EndTest();
			reporter.FlushResult();
		}

	}


}
