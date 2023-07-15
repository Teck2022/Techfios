package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import base.BaseTest;
import utilities.ReadExcel;

public class Test1 extends BaseTest {


	@SuppressWarnings("deprecation")
	@Test(dataProviderClass = ReadExcel.class, dataProvider = "testData")
	public static void LoginTest() throws InterruptedException {
		
		driver.get("https://techfios.com/billing/?ng=admin/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id(loc.getProperty("email_field"))).sendKeys("demo@techfios.com");
		driver.findElement(By.id(loc.getProperty("pwd_field"))).sendKeys("abc123");
		driver.findElement(By.name(loc.getProperty("login_button"))).click();
	
	}

}
