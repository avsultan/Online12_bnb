package com.bnb.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bnb.utils.Driver;

public class MapPage {
	
	public MapPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy(xpath="//span[@_ngcontent-c5]")
	public List<WebElement> roomNames;
	
	@FindBy(xpath="//div[@class='navbar-item has-dropdown is-hoverable']")
	public WebElement myNavBar;
	
	@FindBy(xpath="//a[@class='navbar-item button is-danger']")
	public WebElement signOutButton;
	
	@FindBy(xpath="//div[@class='container']/h1")
	public WebElement VATitleText;
	
	@FindBy(xpath="//div[@class='container']/h2")
	public WebElement darkSideSubTitleText;
	
	@FindBy(xpath="//a[.='self']")
	public WebElement self;
	
	@FindBy(xpath="//a[.='team']")
	public WebElement team;
	
	public WebElement goToRoom(String str) {
		return Driver.getDriver().findElement(By.xpath("//span[.='"+str+"']"));
		
		
	}

}
