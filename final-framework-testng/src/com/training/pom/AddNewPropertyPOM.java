package com.training.pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AddNewPropertyPOM extends LoginPOM{

	public AddNewPropertyPOM(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(id = "menu-posts-property")
	private WebElement propertiesTab;
	
	@FindBy(linkText = "Add New")
	private WebElement addNew;
	
	@FindBy(xpath = "//*[@name = 'post_title']")
	private WebElement title;
	
	@FindBy(id = "ui-id-1")
	private WebElement priceTab;
	
	@FindBy(id ="_price")
	private WebElement price;
	
	@FindBy(id = "_price_per")
	private WebElement pricePer;
	
	@FindBy(linkText = "Main Details")
	private WebElement mainDetailsTab;
	
	@FindBy(id = "_status")
	private WebElement status;
	
	@FindBy(id = "_location")
	private WebElement location;
	
	@FindBy(id = "_possession")
	private WebElement possession;
	
	@FindBy(linkText = "Location")
	private WebElement locationTab;
	
	@FindBy(id = "_friendly_address")
	private WebElement address;
	
	@FindBy(id = "_address")
	private WebElement googleMapAddress;
	
	@FindBy(id = "_geolocation_lat")
	private WebElement latitude;
	
	@FindBy(id = "_geolocation_long")
	private WebElement longitude;
	
	@FindBy(linkText = "Details")
	private WebElement detailsTab;
	
	@FindBy(id = "_storage_room")
	private WebElement storageRoom;
	
	@FindBy(xpath = "//*[@data-id='57']/label/input")
	private WebElement checkBoxCB;
	
	@FindBy (id = "publish")
	private WebElement publish;
	
	public void addNewPropertyPage()
	{
		Actions act = new Actions(driver);
		act.moveToElement(propertiesTab).build().perform();
		this.addNew.click();
		//this.propertiesTab.click();
	}
	
	public void addNewPropertyTitle(String titleName)
	{
		this.title.sendKeys(titleName);
	}
	
	public void addNewPropertyPrice(String price, String pricePer)
	{
		//price tab
		if(this.priceTab.isSelected()==false)
			this.priceTab.click();
		this.price.sendKeys(price);
		this.pricePer.sendKeys(pricePer);
	}
	
	
	public void addNewPropertyMainDetails(String status, String location, String possession)
	{
		//Main Details Tab
		this.mainDetailsTab.click();
		this.status.sendKeys(status);
		this.location.sendKeys(location);
		this.possession.sendKeys(possession);
	}
	
	public void addNewPorpertyLocation(String addr, String googleMapAddr, String lat, String lon)
	{
		this.locationTab.click();
		this.address.sendKeys(addr);
		this.googleMapAddress.sendKeys(googleMapAddr);
		this.latitude.sendKeys(lat);
		this.longitude.sendKeys(lon);
	}
	
	public void addNewPropertyDetails(String storageRoom)
	{
		this.detailsTab.click();
		this.storageRoom.sendKeys(storageRoom);
		
	}
	
	public void checkCentralBlr()
	{
		this.checkBoxCB.click();
	}
	
	public void publish()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", publish);
		//this.publish.click();
	}

}
