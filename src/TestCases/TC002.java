package TestCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import Reports.Reporter;
import SupportingClass.CommonFunctions;

@Listeners(Reports.Listeners.class)
public class TC002 extends CommonFunctions {

	public String path = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		String className = this.getClass().getName();
		try {
			className = (className.split("\\.", 2))[1];
		} catch (Exception e) {
			e.printStackTrace();
		}
		Reporter.StartTestCase(className, "Decription");
	}

	@Test(enabled = true,retryAnalyzer=Reports.RetryTimes.class)
	public void test() throws IOException {

		System.setProperty("webdriver.chrome.driver", path + "\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://google.com");
		driver.manage().window().maximize();
		Reporter.TestStep(driver, "PASS", "Google home page");
		Reporter.TestStep(driver, "FAIL", "Failed - Google home page");
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		driver.quit();
		Reporter.EndResult();

	}

}
