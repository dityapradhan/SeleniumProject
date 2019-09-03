package com.training.sanity.tests;

import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LostYourPasswordPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class LostYourPasswordTests{
	
	private WebDriver driver;
	private LostYourPasswordPOM lostPasswordPOM;
	private String baseUrl;
	private Properties properties;
	//private ScreenShot screenShot;
	
	
	
	
	@Test //To verify whether application allows the user to recover the password 
	public void RETC_003() throws InterruptedException {
		System.out.println("Start executing RETC_003");
	
	 //Navigate to Login/Register Page registerPOM.loginRegister();
		lostPasswordPOM.loginRegister();
		
	 //goto Login tab if
	  //lostPasswordPOM.loginTab();
	  Thread.sleep(5000);
	  //lostPasswordPOM.clickLostPassword();
	  
	  System.out.println(driver.findElement(By.xpath("//*[@class='form-row']/following-sibling::p/a")).isEnabled());
	  
	  WebDriverWait myWait = new WebDriverWait(driver, 60);
	  myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='form-row']/following-sibling::p/a")));
	  lostPasswordPOM.clickLostPassword();
	  
	 /*Actions act = new Actions(driver);
	  act.moveToElement(driver.findElement(By.xpath("//*[@class='form-row']/following-sibling::p/a"))).click().build().perform();*/
	 
	 }

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("before method of LostPassword");
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		lostPasswordPOM = new LostYourPasswordPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		//screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}

	@AfterMethod
	public void afterMethod() throws InterruptedException {
		Thread.sleep(2000);
		//driver.close();
	}

	@BeforeClass
	public void beforeClass() throws IOException {
		System.out.println("Before class executed");
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

}
