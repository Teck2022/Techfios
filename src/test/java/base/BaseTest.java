package base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseTest {

	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static Properties loc = new Properties();
	public static FileReader fReader;
	public static FileReader fReader1;

	@BeforeMethod
	public void setUp() throws IOException {
		
		if(driver==null) {
			FileReader fReader = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\configfiles\\config.properties");
			FileReader fReader1 = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\configfiles\\locators.properties");
			prop.load(fReader);
			loc.load(fReader1);
		
		}
		
		if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup(); 
			driver = new ChromeDriver();
			driver.get(prop.getProperty("testURL"));
		}
		
/*		else if (prop.getProperty("brower").equalsIgnoreCase("firfox")) {
			WebDriverManager.firefoxdriver().setup(); 
			driver = new FirefoxDriver();
			driver.get(prop.getProperty("testURL"));
		}*/
		
}
	
	@AfterMethod
	public void tearDown() {
		
		driver.close();
		driver.quit();

	}
}
