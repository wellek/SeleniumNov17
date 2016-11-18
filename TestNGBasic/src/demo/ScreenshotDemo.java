package demo;

import java.io.File;
import java.io.IOException;
import java.util.Date;
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

public class ScreenshotDemo {
WebDriver driver;
	
	@BeforeTest
	public void openBrowser(){
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://newtours.demoaut.com");
		
	}	
	
	@Test
    public void testApplication() throws IOException{
	 try{
      driver.findElement(By.name("userName")).sendKeys("mercury");//username
      driver.findElement(By.name("password")).sendKeys("mercury"); //password
      driver.findElement(By.name("login")).click();// button - sign in
      driver.findElement(By.name("findFlights")).click();// button - Continue
	  driver.findElement(By.name("reserveFlights")).click();// button - Continue
	  
	  driver.findElement(By.name("First0")).sendKeys("Irina");
// deleted pass from name NoSuchElementExcetpion	  
	  driver.findElement(By.name("passLast0")).sendKeys("McD");
	  driver.findElement(By.name("creditnumber")).sendKeys("1234");
	  driver.findElement(By.name("buyFlights")).click();// Secure purchase button
	  
	  String expectedMsg = "Your itinerary has been booked!";
	   
	  String actualMsg = driver.findElement(By.xpath
			  ("html/body/div[1]/table/tbody/tr/"
			  		+ "td[2]/table/tbody/tr[4]/td/"
			  		+ "table/tbody/tr[1]/td[2]/table/"
			  		+ "tbody/tr[3]/td/p/font/b/font[2]")).getText();
	   
	  Assert.assertEquals(expectedMsg, actualMsg);
//	  System.out.println("Expected result doesn’t match with actual result");
	 }
//	 catch(NoSuchElementException e){
//	 
	 catch (Exception e){
		 getScreenshot(); //  calling method
		 System.out.println("Input not valid");
	 }
    }
	private void getScreenshot() throws IOException {
		Date date = new Date();
		 System.out.println ("date " + date);
		String x = date.toString();
		 System.out.println ("String x " + x);
        String output=x.replaceAll("\\s", "");
	     System.out.println ("output " + output);
		String y = output.replace(':','_');
		 System.out.println ("String y  " + y);
		String t = y.substring(0,16);
		 System.out.println ("String t  " + t);
		File ss = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(ss, new File ("C:\\Selenium\\Newtours" + t + ".jpg"));
//		FileUtils.copyFile(ss, new File ("C:\\Selenium\\Newtours3.jpg"));
	}

	@AfterTest
	public void closeBroser(){
	driver.close();
}
}
