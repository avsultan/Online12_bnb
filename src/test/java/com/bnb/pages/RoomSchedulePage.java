package com.bnb.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bnb.utils.Driver;



public class RoomSchedulePage {

	public RoomSchedulePage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy(xpath="//h1[.='kilimanjaro']")
	public WebElement headerText;
	
	
	public List<WebElement> getAvailableTime(int dayFromToday){
		String xpath = "//table[@class='card table is-fullwidth is-transparent borderless']/tbody/tr["+
							(dayFromToday+1)+"]//td";
		
		return Driver.getDriver().findElements(By.xpath(xpath));
	}
	
	@FindBy(xpath="//a[@class='navbar-item'][.='map']")
	public WebElement mapLink;
	
	@FindBy(xpath="//a[@class='navbar-item'][.='schedule']")
	public WebElement scheduleLink;
	
	@FindBy(xpath="//a[@class='navbar-item'][.='hunt']")
	public WebElement huntLink;
	
	@FindBy(xpath="//a[.='my']")
	public WebElement myLink;
	
	@FindBy(xpath="//table[@class='card table is-fullwidth is-transparent borderless']")
	public WebElement scheduleTable;
	
	@FindBy(tagName="mat-dialog-container")
	public WebElement confTable;




}
