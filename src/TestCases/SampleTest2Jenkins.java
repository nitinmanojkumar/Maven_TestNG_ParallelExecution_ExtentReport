package TestCases;

import org.testng.annotations.Test;

public class SampleTest2Jenkins {

	@Test(priority=1)
	public void test() throws InterruptedException {
		System.out.println("Hey second test");
		Thread.sleep(6000);

	}
	
	@Test(priority=2)
	public void tes1t() throws InterruptedException {
		System.out.println("Hey second1 test");
		Thread.sleep(6000);

	}

}
