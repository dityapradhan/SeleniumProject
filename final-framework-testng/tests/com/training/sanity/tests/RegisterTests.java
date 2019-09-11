package com.training.sanity.tests;

import org.testng.annotations.Test;
import com.training.pom.RegisterPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class RegisterTests {

	private WebDriver driver;
	public String baseUrl;
	public Properties properties;
	private RegisterPOM registerPOM;
	private String actualResult;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		System.out.println("Before Test executed");
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);

	}

	@Test
	// To verify whether application allows the user to get registered upon
	// entering valid credentials
	public void RETC_001() {
		System.out.println("Start executing RETC_001");

		// Navigate to Login/Register Page
		registerPOM.loginRegister();
		actualResult = driver.getTitle();
		Assert.assertEquals(actualResult, "My Profile – Real Estate");
		/*
		 * if (actualResult.equals("My Profile – Real Estate"))
		 * System.out.println("RETC_001 Step 1 : PASSED");
		 */

		// goto Register tab
		registerPOM.registerTab();
		Assert.assertEquals(driver.findElement(By.xpath("//*[@value = 'Register']")).isDisplayed(), true);
		/*
		 * if
		 * (driver.findElement(By.xpath("//*[@value = 'Register']")).isDisplayed
		 * () == true) System.out.println("RETC_001 Step 2 : PASSED");
		 */

		registerPOM.enterEmail("ditya.pradhan@in.ibm.com");
		registerPOM.enterFName("ditya");
		registerPOM.enterLName("pradhan");
		registerPOM.clickRegister();
		// driver.findElement(By.id("post-133"))
		WebElement success = (WebElement) driver.findElement(By.xpath("//*[@class='notification success closeable']"));
		Assert.assertNotNull(success);

	}

	@BeforeMethod
	public void beforeMethod() throws Exception {
		System.out.println("BeforeMethod of register");
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		registerPOM = new RegisterPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		System.out.println(baseUrl);
		driver.get(baseUrl);
	}

	@AfterMethod
	public void afterMethod() throws InterruptedException {
		System.out.println("AfterMethod of register");
		driver.close();
	}

}
