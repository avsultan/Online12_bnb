package com.bnb.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bnb.utils.Driver;

public class FreeSpotsPage {

	public FreeSpotsPage() {
		PageFactory.initElements(Driver.getDriver(),this);
	}
	
	@FindBy(xpath="//div[@class='column is-one-third ng-star-inserted']/div/div/p[1]")
	public List<WebElement> freeRooms;
	
	public WebElement bookButton(int roomNumber) {
		String xpath = "//div[@class='columns is-multiline is-centered ng-star-inserted']/div["+
						roomNumber+"]//button";
		
		return Driver.getDriver().findElement(By.xpath(xpath));
	}
}
