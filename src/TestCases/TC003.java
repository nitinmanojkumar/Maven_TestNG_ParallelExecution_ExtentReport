package TestCases;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Reports.Reporter;
import SupportingClass.CommonFunctions;

public class TC003 extends CommonFunctions{

	Reporter reporter;
	public String path = System.getProperty("user.dir");

	public TC003() {
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
	
	@Test(enabled = true, retryAnalyzer = Reports.RetryTimes.class, dataProvider = "dp")
	public void ToolsQA(String str) throws IOException {
		WebDriver driver = new ChromeDriver();
		reporter.StartTestCase("ToolsQA","Desc");
		try {

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("https://www.toolsqa.com/selenium-webdriver/testng-listeners/");
			driver.manage().window().maximize();
			
			
			Explicitwait(driver,
					"(//a[@href='http://toolsqa.com/selenium-webdriver/configure-eclipse-with-selenium-webdriver/'])[2]");
			js_scrollDown(driver);
			reporter.TestStepWithScreenshot(driver, "PASS", "First down scroll by pixels");
			js_scrollUp(driver);
			reporter.TestStepWithScreenshot(driver, "PASS", "First up scroll by pixels");

			js_scrollBottom(driver);
			reporter.TestStep(driver, "PASS", "Scrolled to bottom");

			js_scrolltoView(driver, driver.findElement(By.xpath(
					"(//a[@href='http://toolsqa.com/selenium-webdriver/configure-eclipse-with-selenium-webdriver/'])[2]")));
			reporter.TestStep(driver, "PASS", "First view scroll");
			js_click(driver, driver.findElement(By.xpath(
					"(//a[@href='http://toolsqa.com/selenium-webdriver/configure-eclipse-with-selenium-webdriver/'])[2]")));
			reporter.TestStepWithScreenshot(driver, "PASS", "First click js scroll");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
			reporter.EndTest();
			reporter.FlushResult();
		}
	}

	@DataProvider
	public Object[][] dp() {
		return new Object[][] { { "data one" },{"data two"} };
	}
	
}
