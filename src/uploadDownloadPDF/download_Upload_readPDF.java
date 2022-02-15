package uploadDownloadPDF;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class download_Upload_readPDF {
	public static String path = System.getProperty("user.dir");
	public static JavascriptExecutor jsexecutor;
	public static WebDriver driver;

	@BeforeTest
	public void launchChrome() {
		System.out.println("Before Test");
		String downloadFilepath = "C:\\SeleniumDrivers";

		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		//chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadFilepath);
		chromePrefs.put("download.prompt_for_download",true);
		chromePrefs.put("directory_upgrade",false);
		chromePrefs.put("plugins.always_open_pdf_externally",true);

		//Save Chrome Opions
		ChromeOptions options = new ChromeOptions();
		HashMap<String, Object> chromeOptionsMap = new HashMap<String, Object>();
		options.setExperimentalOption("prefs", chromePrefs);

		System.setProperty("webdriver.chrome.driver", path + "\\Driver\\chromedriver.exe");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
			
		
	}
	
	@Test(enabled=false)
	public void downloadFileOnClick() {
		try {
			
			driver.get("http://demo.automationtesting.in/FileDownload.html");
			driver.findElement(By.id("pdfbox")).sendKeys("hey");
			driver.findElement(By.id("createPdf")).click();
			driver.findElement(By.id("pdf-link-to-download")).click();	
		} catch (Exception e) {

		}
	}

	@Test
	public void downloadFileOnPreviewType() {
		try {
			
			driver.get(System.getProperty("user.dir") + "//src//propertiesVsAttributes//propANDattributes2.html");
			Thread.sleep(1000);
			driver.findElement(By.name("download")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("download")).click();
			Thread.sleep(3000);
		} catch (Exception e) {

		}
	}

}
