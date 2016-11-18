package demo;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Facebook {
WebDriver driver;
	
	@BeforeTest
	
	public void openBrowser(){
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("https://facebook.com");		
	}
	
//	@Test (priority = 0)
//	public void verifyTitle(){
//	  
//		String expectedTitle = "Facebook - Log In or Sign Up";
//		String actualTitle = driver.getTitle();
//		Assert.assertEquals(actualTitle, expectedTitle);
//		}
	
	@Test //(priority = 1)
	public void verifyText() throws IOException{
	  try{
		
		String expectedText ="Connect with friends and the world around you on Facebook.";
		  
		String actualText = driver.findElement(By.xpath("//*[@id='content']/div/div/div/div/div[1]/h2")).getText();
		  
		Assert.assertEquals(actualText, expectedText);		
			}
	   	
	 catch (Exception e){
		 getScreenshot(); //  calling method
		 System.out.println("Input text not valid");
	 }
	}
	private void getScreenshot() throws IOException {
		File ss = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(ss, new File ("C:\\Selenium\\facebook.jpg"));
	} 	
	
	@AfterTest
	public void closeBrowser(){
		driver.quit();
	}
}
