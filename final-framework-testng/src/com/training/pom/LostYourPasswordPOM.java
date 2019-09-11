package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LostYourPasswordPOM extends LoginPOM {

	// WebDriver driver;

	public LostYourPasswordPOM(WebDriver driver) {
		super(driver);
	}

	@FindBy(linkText = "Lost Your Password?")
	private WebElement lostPassword;

	@FindBy(id = "user_login")
	private WebElement email;

	@FindBy(xpath = "//*[@class='lostpassword-button']")
	private WebElement lostPasswordButton;

	public void clickLostPassword() throws InterruptedException {
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", lostPassword);
	}

	public void enterEmail(String email) {
		this.email.sendKeys(email);
	}

	public void clickLostPasswordButton() {
		this.lostPasswordButton.click();

	}

	/*public void openMailBox(String email, String password) throws InterruptedException {

		driver.get("http://www.gmail.com");
		driver.findElement(By.id("identifierId")).sendKeys(email);
		Thread.sleep(1000);
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).build().perform();
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys(password);
		act.sendKeys(Keys.ENTER).build().perform();
		driver.findElement(By.xpath("//*[@class = 'gb_jf']")).sendKeys("realestate");
		act.sendKeys(Keys.ENTER).build().perform();
	}
*/
	/*public void resetPassword() {

	}*/

}
