package com.bnb.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bnb.utils.Driver;

public class SelfPage {
	
	public SelfPage() {
		PageFactory
		.initElements(Driver.getDriver(), this);
	}
	
	@FindBy(xpath="/html/body/app-root/div/app-me-page/app-hero/section/app-hero-body/div/div/h1")
	public WebElement title;
	
	@FindBy(xpath="/html/body/app-root/div/app-me-page/div/div/div/div/app-user-card/div/div/div[1]/div[2]/p[1]")
	public WebElement name;
	
	@FindBy(xpath="(//p[@class='title is-6'])[2]")
	public WebElement role;
	
	@FindBy(xpath="(//p[@class='title is-6'])[3]")
	public WebElement team;
	
	@FindBy(xpath="(//p[@class='title is-6'])[4]")
	public WebElement batch;
	
	@FindBy(xpath="(//p[@class='title is-6'])[5]")
	public WebElement campus;

}
