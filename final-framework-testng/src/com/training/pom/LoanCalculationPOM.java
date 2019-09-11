package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LoanCalculationPOM extends LoginPOM {

	private Actions act = new Actions(driver);

	public LoanCalculationPOM(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//*[@id= 'wp-admin-bar-site-name']/a")
	private WebElement homeLink;

	@FindBy(id = "wp-admin-bar-view-site")
	private WebElement viewSite;

	@FindBy(id = "menu-item-354")
	private WebElement newLaunch;

	@FindBy(xpath = "//*[@title='Nullam hendrerit Apartments']")
	private WebElement apartmentIcon;

	@FindBy(xpath = "//*[@class='property-slider default  slick-initialized slick-slider']/button[2]")
	private WebElement nextButton;

	@FindBy(xpath = "//*[@name = 'your-name']")
	private WebElement enquiryName;

	@FindBy(xpath = "//*[@name = 'your-email']")
	private WebElement enquiryEmail;

	@FindBy(xpath = "//*[@name = 'your-subject']")
	private WebElement enquirySubject;

	@FindBy(xpath = "//*[@name = 'your-message']")
	private WebElement enquiryMessage;

	@FindBy(xpath = "//*[@class = 'wpcf7-form-control wpcf7-submit']")
	private WebElement enquirySendBtn;

	@FindBy(id = "amount")
	private WebElement mortgageSalePrice;

	@FindBy(id = "downpayment")
	private WebElement mortgageDownPayment;

	@FindBy(id = "years")
	private WebElement mortgageLoanTerm;

	@FindBy(id = "interest")
	private WebElement mortgageInterestRate;

	@FindBy(xpath = "//*[@class='button calc-button']")
	private WebElement calculateMortgageBtn;

	public void home() {
		act.moveToElement(homeLink).build().perform();
		this.viewSite.click();
	}

	public void viewNewLaunch() throws InterruptedException {
		act.moveToElement(newLaunch).build().perform();
		// Steps: 2. Click on Nullam hendrerit apartment icon and 3. click on
		// >arrow
		this.apartmentIcon.click();
		Thread.sleep(3000);
		List<WebElement> slide = (List<WebElement>) driver
				.findElements(By.xpath("//*[@class='item slick-slide slick-active']"));
		int size = slide.size();
		for (int i = 0; i < size; i++) {
			this.nextButton.click();
			Thread.sleep(3000);
		}
	}

	public void sendEnquiry(String name, String email, String subject, String msg) {
		this.enquiryName.sendKeys(name);
		this.enquiryEmail.sendKeys(email);
		this.enquirySubject.sendKeys(subject);
		this.enquiryMessage.sendKeys(msg);
		this.enquirySendBtn.click();
	}

	public void mortgageCalculator(String price, String downPayment, String loanTerm, String interest) {
		this.mortgageSalePrice.sendKeys(price);
		this.mortgageDownPayment.sendKeys(downPayment);
		this.mortgageLoanTerm.sendKeys(loanTerm);
		this.mortgageInterestRate.sendKeys(interest);
		this.calculateMortgageBtn.click();
	}
}
