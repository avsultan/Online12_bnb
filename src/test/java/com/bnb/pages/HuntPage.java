package com.bnb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.bnb.utils.Driver;

public class HuntPage {

	public HuntPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy(xpath = "//a[.='hunt']")
	public WebElement huntLink;

	@FindBy(id = "date")
	public WebElement date;

	@FindBy(id = "timelineStart")
	public WebElement timeLineStart;

	@FindBy(id = "timelineFinish")
	public WebElement timeLineFinish;

	public Select selectTimeStart() {
		Select select = new Select(timeLineStart);
		return select;

	}

	public Select selectTimefinish() {
		Select select = new Select(timeLineFinish);
		return select;

	}
	@FindBy(xpath = "//div[.='you already have a conference for 2018-08-25.']")
	public WebElement alreadyReservedText;


	@FindBy(tagName = "button")
	public WebElement searchButton;

	@FindBy(tagName = "button")
	public WebElement confirmButton;

	public String rmName(String str) {

		return Driver.getDriver().findElement(By.xpath("//p[.=' " + str + " ']")).getText();

	}

	public WebElement bookButton(String str) {
		return Driver.getDriver().findElement(By.xpath("//p[.=' " + str + " ']/following::footer/div//button"));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
