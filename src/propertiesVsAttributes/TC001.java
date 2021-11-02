package propertiesVsAttributes;

import java.util.Currency;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TC001 {

	public static String path = System.getProperty("user.dir");
	public static JavascriptExecutor jsexecutor;
	public static WebDriver driver;

	public static void main(String[] args) {
		try {
			
			for(int i=0;i<args.length;i++) {
				System.out.println("Number : "+i);
			}
			
			/*System.setProperty("webdriver.chrome.driver", path + "\\Driver\\chromedriver.exe");
			System.out.println(System.getProperty("user.dir"));
			driver = new ChromeDriver();
			driver.get(System.getProperty("user.dir") + "//src//propertiesVsAttributes//propANDattributes.html");
			Thread.sleep(3000);
			driver.findElement(By.id("fname")).clear();
			driver.findElement(By.id("fname")).sendKeys("Mannoj");
			jsexecutor=(JavascriptExecutor)driver;
			String HTMLValue=(String)jsexecutor.executeScript("return document.getElementById('fname').getAttribute('value')");
			String attValue=(String)jsexecutor.executeScript("return document.getElementById('fname').defaultValue");
			String DOMPropertyValue=(String)jsexecutor.executeScript("return document.getElementById('fname').value");
			System.out.println("HTML Value remains unchanged but the DOM value will be changed");
			System.out.println("HTMLValue : "+HTMLValue+"\n"+"attributeValue : "+attValue+"\n"+"DOMPropertyValue : "+DOMPropertyValue);

			driver.close();*/
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}

	}

}
