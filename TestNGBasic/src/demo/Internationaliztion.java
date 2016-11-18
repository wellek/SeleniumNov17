package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Internationaliztion {
WebDriver driver;
	
	@BeforeTest
	public void openBrowserr(){
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("intl.accept_languages", "ru");
		driver = new FirefoxDriver(profile);
// if don't specify , it gives default profile
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://gmail.com");
		
	}
	 @Test
	 public void testApplication(){
		 driver.findElement(By.id("Email")).sendKeys("byирина@gmail.com");
		 driver.findElement(By.id("next")).click();
	 }
	
}
