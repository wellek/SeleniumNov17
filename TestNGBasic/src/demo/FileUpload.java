package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

public class FileUpload {

	// new info
	WebDriver driver; // declare webdriver at class level
	// otherwise error: driver cannot be resolved

	@BeforeTest // precondition
	public void openBrowser(){ 
	driver = new FirefoxDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get("http://www.barnesandnoble.com/");
}
}
