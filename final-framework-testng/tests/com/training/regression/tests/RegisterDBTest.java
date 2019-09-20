package com.training.regression.tests;

import org.testng.annotations.Test;

import com.training.dataproviders.RegisterDataProviders;
import com.training.pom.RegisterPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class RegisterDBTest {

	// To verify whether details entered by user during registration get
	// displayed in database
	private Properties properties;
	private WebDriver driver;
	private String baseUrl;
	private RegisterPOM registerPOM;

	@Test(dataProvider = "db-input", dataProviderClass = RegisterDataProviders.class)
	public void registerDBTest(String email, String firstname, String lastname) {
		registerPOM.loginRegister();
		registerPOM.registerTab();
		registerPOM.enterEmail(email);
		registerPOM.enterFName(firstname);
		registerPOM.enterLName(lastname);
		registerPOM.clickRegister();

	}

	@BeforeMethod
	public void beforeMethod() {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		baseUrl = properties.getProperty("baseURL");
		registerPOM = new RegisterPOM(driver);
		driver.get(baseUrl);
	}

	@AfterMethod
	public void afterMethod() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}

	@BeforeClass
	public void beforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

}
