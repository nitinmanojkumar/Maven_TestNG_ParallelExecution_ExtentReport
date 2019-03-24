package SupportingClass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import Reports.Reporter;

public class CommonFunctions {

	
	public static boolean Explicitwait(WebDriver driver, String locator) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(locator))));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean js_sendkeys(WebDriver driver,String locator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('id').value='sendkeysvalue';");
		//js.executeScript("arguments[0].value='sendkeysvalue';", WebElement);
		return true;
	}

	public static boolean js_click(WebDriver driver,WebElement locator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", locator);
		//js.executeScript("document.getElementById('id').click();");
		return true;
	}
	
	public static boolean js_scrollDown(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		return true;
	}

	public static boolean js_scrollUp(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-250)", "");
		return true;
	}

	public static boolean js_scrollBottom(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		return true;
	}

	public static boolean Robot_pressDownkey(WebDriver driver) throws AWTException {
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
		return true;
	}

	public static boolean Robot_pressUpkey(WebDriver driver) throws AWTException {
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
		return true;
	}

	public static boolean js_scrolltoView(WebDriver driver,WebElement locator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", locator);
		return true;
	}

	public static boolean action_pagedown(WebDriver driver) {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN);
		return true;
	}

	public static boolean action_pageup(WebDriver driver) {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_UP);
		return true;
	}

}
