package Reports;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Reporter {

	public Reporter() {

	}
	public ExtentReports report;
	public ExtentTest test;
	public File file;
	public String screenshotfile;

	static String path = System.getProperty("user.dir");

	public void StartResult(String Result) {
		System.out.println("start result");
		report = new ExtentReports(path + "//Reports//" + Result + "_" + System.currentTimeMillis() + ".html");
	}

	public void EndTest() {
		report.endTest(test);
	}

	public void FlushResult() {
		report.flush();
	}

	public void StartTestCase(String TCName, String Desc) {
		test = report.startTest(TCName, Desc);
	}

	public static void Screenshot(WebDriver driver, String stepAction) throws IOException {
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenshotfile = path + "/Screeshots/" + stepAction + "_" + System.currentTimeMillis() + ".png";
		FileUtils.copyFile(file, new File(screenshotfile));
	}

	public void TestStep(WebDriver driver, String status, String stepAction) throws IOException {

		//Screenshot(driver, stepAction);
		status = status.toUpperCase();
		switch (status) {
		case "PASS":
			test.log(LogStatus.PASS, stepAction);
			break;
		case "FAIL":
			test.log(LogStatus.FAIL, stepAction );
			break;
		default:
			test.log(LogStatus.UNKNOWN, stepAction);
			break;
		}
	}
	
	public void TestStepWithScreenshot(WebDriver driver, String status, String stepAction) throws IOException {

		file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		screenshotfile = path + "/Screeshots/" + stepAction + "_" + System.currentTimeMillis() + ".png";
		FileUtils.copyFile(file, new File(screenshotfile));
		status = status.toUpperCase();
		switch (status) {
		case "PASS":
			test.log(LogStatus.PASS, stepAction+test.addScreenCapture(screenshotfile));
			break;
		case "FAIL":
			test.log(LogStatus.PASS, stepAction+test.addScreenCapture(screenshotfile));
			break;
		default:
			test.log(LogStatus.UNKNOWN, stepAction);
			break;
		}
	}

}
