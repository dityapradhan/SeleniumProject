package com.training.sanity.tests;

import org.testng.annotations.Test;

import com.training.pom.AddNewPropertyPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class AddNewPropertyTests {

	private WebDriver driver;
	private String baseUrl;
	private AddNewPropertyPOM addNewPropertyPOM;
	private static Properties properties;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		System.out.println("Before class executed");
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@Test
	public void addNewProperty() {
		// login using admin user : Precondition
		addNewPropertyPOM.loginRegister();
		addNewPropertyPOM.loginTab();
		addNewPropertyPOM.sendUserName("admin");
		addNewPropertyPOM.sendPassword("adminuser@12345");
		addNewPropertyPOM.clickLoginBtn();

		// Go to properties tab and add new property
		addNewPropertyPOM.addNewPropertyPage();
		addNewPropertyPOM.addNewPropertyTitle("new launch");
		addNewPropertyPOM.addNewPropertyPrice("50000.00", "200.00");
		addNewPropertyPOM.addNewPropertyMainDetails("New", "Electronic city", "immediate");
		addNewPropertyPOM.addNewPorpertyLocation("yeshwanthapur", "yeshwanthapur", "120", "56");
		addNewPropertyPOM.addNewPropertyDetails("2");
		addNewPropertyPOM.checkCentralBlr();
		addNewPropertyPOM.publish();

		//Assertion
		Assert.assertEquals(driver.findElement(By.id("message")).getAttribute("class"),
				"updated notice notice-success is-dismissible");

	}

	@BeforeMethod
	public void setUp() throws Exception {
		System.out.println("before method of AddNewProperty");
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		addNewPropertyPOM = new AddNewPropertyPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		driver.get(baseUrl);
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("after method of AddNewProperty");
		driver.quit();
	}

}
