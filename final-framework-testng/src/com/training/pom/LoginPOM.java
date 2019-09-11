package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOM extends RegisterPOM {

	public LoginPOM(WebDriver driver) {
		super(driver);

	}

	@FindBy(linkText = "Log In")
	private WebElement loginTab;

	@FindBy(id = "user_login")
	private WebElement userName;

	@FindBy(id = "user_pass")
	private WebElement password;

	@FindBy(xpath = "//*[@value = 'Sign In']")
	private WebElement loginBtn;
	
	@FindBy(xpath ="//*[@class='my-account-nav-container']/ul[2]/li/a")
	private WebElement changePassword;
	
	@FindBy(xpath="//*[@name='current_pass']")
	private WebElement currentPassword;
	
	@FindBy(xpath="//*[@name='pass1']")
	private WebElement newPassword1;
	
	@FindBy(xpath="//*[@name='pass2']")
	private WebElement newPassword2;
	
	//changePasswordButton
	@FindBy(id="wp-submit")
	private WebElement submitButton;
	

	public void loginTab() {
		this.loginTab.click();
	}

	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}

	public void sendPassword(String password) {
		this.password.clear();
		this.password.sendKeys(password);
	}

	public void clickLoginBtn() {
		this.loginBtn.click();
	}
	
	public void changePassword(CharSequence currPass, CharSequence newPass1, CharSequence newPass2)
	{
		this.changePassword.click();
		this.currentPassword.sendKeys(currPass);
		this.newPassword1.sendKeys(newPass1);
		this.newPassword2.sendKeys(newPass2);
		this.submitButton.click();
		
	}
}
