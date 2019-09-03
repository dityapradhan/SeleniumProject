package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LostYourPasswordPOM {
	
	WebDriver driver;
	
	public LostYourPasswordPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@class='right-side-menu-item']")
	private WebElement loginRegisterLink;
	
	/*@FindBy(xpath = "//*[@class='lost_password']")
	private WebElement lostPassword;*/
	
	@FindBy(linkText = "Lost Your Password?")
	private WebElement lostPassword;
	
	//go to register page from main page
		public void loginRegister()
		{
			this.loginRegisterLink.click();
		}
	
	public void clickLostPassword() throws InterruptedException
	{
		Thread.sleep(3000);
		this.lostPassword.click();
	}
}
