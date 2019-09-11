package com.training.sanity.tests;

import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LostYourPasswordPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class LostYourPasswordTests {

	private WebDriver driver;
	private LostYourPasswordPOM lostPasswordPOM;
	private String baseUrl;
	private Properties properties;
	// private ScreenShot screenShot;

	@Test // To verify whether application allows the user to recover the
			// password
	public void RETC_003() throws InterruptedException {
		System.out.println("Start executing RETC_003");

		// Navigate to Login/Register Page registerPOM.loginRegister();
		lostPasswordPOM.loginRegister();

		// goto Login tab if
		lostPasswordPOM.loginTab();
		lostPasswordPOM.clickLostPassword();
		lostPasswordPOM.enterEmail("ditya.pradhan@in.ibm.com");
		lostPasswordPOM.clickLostPasswordButton();

		// Assertion for successful

	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("before method of LostPassword");
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		lostPasswordPOM = new LostYourPasswordPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		// open the browser
		driver.get(baseUrl);
	}

	@AfterMethod
	public void afterMethod() throws InterruptedException {
		driver.close();
	}

	@BeforeClass
	public void beforeClass() throws IOException {
		System.out.println("Before class executed");
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

}
