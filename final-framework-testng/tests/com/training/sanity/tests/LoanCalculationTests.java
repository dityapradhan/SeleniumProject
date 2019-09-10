package com.training.sanity.tests;

import org.testng.annotations.Test;

import com.training.pom.LoanCalculationPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.http.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class LoanCalculationTests {

	private LoanCalculationPOM loanCalculationPOM;
	private static Properties properties;
	private WebDriver driver;
	private String baseUrl;

	@Test
	public void loanCalculation() {
		//login as admin
		loanCalculationPOM.loginRegister();
		loanCalculationPOM.loginTab();
		loanCalculationPOM.sendUserName("admin");
		loanCalculationPOM.sendPassword("adminuser@12345");
		loanCalculationPOM.clickLoginBtn();
		
		//view, enquire & calculate loan on New launches
		loanCalculationPOM.home();
		loanCalculationPOM.viewNewLaunches();
		loanCalculationPOM.sendEnquiry("selenium", "selenium@gmail.com", "apartment", "looking for apartment");
		loanCalculationPOM.mortgageCalculator("40000", "2000", "2", "5");
		
		//System.out.println(driver.findElements(By.xpath("//*[@class='calc-output']")));
		Assert.assertEquals(driver.findElements(By.xpath("//*[@class='notification success']/strong")), arg1);
		
	}

	@BeforeMethod
	public void beforeMethod() {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loanCalculationPOM = new LoanCalculationPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		driver.get(baseUrl);

	}

	@AfterMethod
	public void afterMethod() throws InterruptedException {
		Thread.sleep(3000);
		//driver.quit();
	}

	@BeforeClass
	public void beforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inputStream = new FileInputStream("./resources/others.properties");
		properties.load(inputStream);
	}

}
