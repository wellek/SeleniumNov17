package demo;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CBT {
	WebDriver driver; // declare webdriver at class level
	// otherwise error: driver cannot be resolved
	
		@BeforeTest 
// precondition
		@Parameters("browser")
	
	
// this browser going to talk to browsers  below we need to
		
		public void openBrowser(String browser) {
// driver = new FirefoxDriver();// open window when create new project
// always install new selenium jar files> right click on TestNGBasics
// project and go to properties: Java Build Path >Jars> add External jars
// and find files under selenium folder
// and import new statements for web driver and firefox driver
			if (browser.equalsIgnoreCase("Firefox")){
				driver = new FirefoxDriver();
			}
//			else if (browser.equalsIgnoreCase("Chrome")){
//				System.setProperty("webdriver.chrome.driver",
//					"C:\\Webdrivers\\chromedriver_win32\\chromedriver.exe");
//				driver = new ChromeDriver();
//			}
			else if (browser.equalsIgnoreCase("IE")){
				System.setProperty("webdriver.ie.driver",
						"C:\\Webdrivers\\IEDriverServer_x64_2.53.1\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			
			}
//			else if (browser.equals("Opera")){
//				System.setProperty("webdriver.opera.driver", "path to exe");
//			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("http://www.barnesandnoble.com/");
		}

		@Test
		// import 2 test statements from pop up -junit and annotations
		public void titleVerification() {
			String expectedTitle = "Online Bookstore: Books, NOOK ebooks, Music, Movies & Toys | Barnes & Noble®";
			String actualTitle = driver.getTitle();
			Assert.assertEquals(actualTitle, expectedTitle);
			// assert is a class, assert equals is the method
		}
 
		@AfterTest // after condition
		public void closeBrowser() {
			driver.close(); // close the most recently open window
		    driver.quit(); // close all the windows during test execution
		}

}
