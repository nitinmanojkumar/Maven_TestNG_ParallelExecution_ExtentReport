package TestCases;

import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SampleTestJenkins {

	public static int val=1;
	
	@Test(dataProvider = "dp",priority=1, invocationCount = 2, threadPoolSize = 2, enabled=false)
	public void test(String one) throws InterruptedException {
		System.out.println(one);
		System.out.println("Hey first test : "+ val);
		val=val+1;
		Thread.sleep(2000);

	}
	
	@Test(enabled=true,priority=2)
	public void tes1t() throws InterruptedException {
		String str1=Keys.chord(Keys.CONTROL, Keys.RETURN);
		System.out.println(str1);
		System.out.println("Hey first1 test");
		Thread.sleep(6000);

	}
	
	@DataProvider
	public Object[][] dp() {
		return new Object[][] { { "data one" } ,{"data two"}};
	}
	
	
}
