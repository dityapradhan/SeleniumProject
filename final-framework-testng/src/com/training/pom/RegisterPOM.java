package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPOM {
	
	protected WebDriver driver;

	public RegisterPOM(WebDriver driver) {
		//super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@class='right-side-menu-item']")
	private WebElement loginRegisterLink;
	
	@FindBy(linkText = "Register")
	private WebElement registerTab;
	
	@FindBy(id = "email")
	private WebElement Email;
	
	@FindBy(id = "first-name")
	private WebElement firstName;
	
	@FindBy(id = "last-name")
	private WebElement lastName;
	
	@FindBy(xpath = "//*[@class='register-button']")
	private WebElement registerButton;
	
	
	//go to register page from main page
	public void loginRegister()
	{
		this.loginRegisterLink.click();
	}
	
	//go to Register tab on the register page
	public void registerTab()
	{
		this.registerTab.click();
	}
	
	
	public void enterEmail(String emailId)
	{
		this.Email.clear();
		this.Email.sendKeys(emailId);
	}
	
	public void enterFName(String fName)
	{
		this.firstName.clear();
		this.firstName.sendKeys(fName);
	}
	
	public void enterLName(String lName)
	{
		this.lastName.clear();
		this.lastName.sendKeys(lName);
	}
	
	public void clickRegister()
	{
		this.registerButton.click();
	}
	
	

}
