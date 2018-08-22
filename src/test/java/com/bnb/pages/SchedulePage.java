package com.bnb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bnb.utils.Driver;

public class SchedulePage {
	public SchedulePage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy(tagName = "h1")
	public WebElement scheduleTitle;
	
	@FindBy(xpath = "//td[@class='conference ng-star-inserted']")
	public WebElement reservedRoom2;
	
	@FindBy(xpath = "//td[@class='conference']")
	public WebElement reservedRoom;
	
	
	@FindBy(xpath = "//*[@class='button is-danger']")
	public WebElement cancelButton;
	
	
	@FindBy(xpath = "//a[text()='schedule']")
	public WebElement scheduleLink;
	
	public WebElement cancelText(String str) {
		return Driver.getDriver().findElement(By.xpath("//*[.='conference in "+str+" has been canceled']"));
	}
}
