package com.bnb.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bnb.utils.Driver;

public class TeamPage {
	
	public TeamPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy(xpath="//h1")
	public WebElement title;
	
	@FindBy(xpath="//p[@class='title is-6']")
	public List<WebElement> names;

}
