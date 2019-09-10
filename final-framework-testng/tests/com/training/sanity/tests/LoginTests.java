package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LoginTests{

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private static Properties properties;
	//private ScreenShot screenShot;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		System.out.println("Before class executed");
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		System.out.println("before method of Login");
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		//screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		System.out.println("after method of Login");
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void RETC_002() {
		System.out.println("Start executing RETC_002");
		loginPOM.loginRegister();
		loginPOM.loginTab();
		loginPOM.sendUserName("ditya.pradhan@in.ibm.com	");
		loginPOM.sendPassword("ibm@12345");
		loginPOM.clickLoginBtn(); 
		
		//Assertion - profile page should be displayed
		Assert.assertEquals(driver.getTitle(), "Dashboard ‹ Real Estate — WordPress");
	}
}
