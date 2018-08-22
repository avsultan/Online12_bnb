package com.bnb.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bnb.utils.Driver;

public class LoginPage {
	
	public LoginPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy(xpath="//div[@class='container']//h1")
	public WebElement signInText;
	
	@FindBy(xpath="//input[@name='email']")
	public WebElement emailInputBox;
	
	@FindBy(xpath="//input[@name='password']")
	public WebElement passwordInputBox;
	
	@FindBy(xpath="//button[@class='button is-dark']")
	public WebElement signInButton;
	
	@FindBy(xpath="//div[@class='cdk-live-announcer-element cdk-visually-hidden']")
	public WebElement notExistMessage;
	
}
