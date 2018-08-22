package com.bnb.stepDefs;

import com.bnb.pages.LoginPage;
import com.bnb.pages.MapPage;
import com.bnb.pages.SchedulePage;
import com.bnb.utils.BrowserUtils;
import com.bnb.utils.Driver;
import com.bnb.stepDefs.LoginStepDefs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.bnb.pages.HuntPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SmokeTestStepDefs {
	LoginPage loginPage = new LoginPage();
	HuntPage huntPage = new HuntPage();
	MapPage mapPage = new MapPage();
	SchedulePage schedulePage = new SchedulePage();
	
	@Given("User logs in as a teacher with user name {string} and password {string}")
	public void user_logs_in_as_a_teacher_with_user_name_and_password(String username, String password) {
		loginPage.emailInputBox.sendKeys(username);
	    loginPage.passwordInputBox.sendKeys(password);
	    
	    loginPage.signInButton.click();
	   
	}

	@Given("User goes to hunt page and selects {string} and time from {string} to {string}")
	public void user_goes_to_hunt_page_and_selects_and_time_from_to(String date, String from, String to) throws Exception {
		
		BrowserUtils.explicitWait(9).until(BrowserUtils.textToBeByElement(mapPage.VATitleText, "VA"));
		huntPage.huntLink.click();
		Driver.getDriver().navigate().refresh();
		huntPage.date.sendKeys(date);
		huntPage.selectTimeStart().selectByVisibleText(from);
		huntPage.selectTimefinish().selectByVisibleText(to);
		


	}

	@When("User clicks search button")
	public void user_clicks_search_button() {
		//BrowserUtils.explicitWait(2).until(BrowserUtils.textToBeByElement(element, value))
		BrowserUtils.waitForClickablility(huntPage.searchButton, 5);
		huntPage.searchButton.click();
	
	}

	@Then("{string} name should be displayed")
	public void name_should_be_displayed(String expRoomName) {
		String actRoomName = huntPage.rmName(expRoomName);
		assertEquals("Room name "+expRoomName+" was not found",expRoomName, actRoomName);
		
	
		
	}

	@When("User clicks book button under {string} table and clicks confirm button")
	public void user_clicks_book_button_under_table_and_clicks_confirm_button(String expRoomName) {
	 huntPage.bookButton(expRoomName).click();
	 huntPage.confirmButton.click();
		
		
	}

	@Then("User should see user's schedule")
	public void user_should_see_user_s_schedule() {
	
	assertTrue(schedulePage.scheduleTitle.isDisplayed());
	BrowserUtils.waitFor(1);
	}

	@When("User click on reserved date and time appeared on the schedule")
	public void user_click_on_reserved_date_and_time_appeared_on_the_schedule() {
		
		if(schedulePage.reservedRoom2.isDisplayed()) {
			schedulePage.reservedRoom2.click();
		}
 
	}
	
	@Then("cancel conference button should be clickable")
	public void cancel_conference_button_should_be_clickable() {
		BrowserUtils.waitForClickablility(schedulePage.cancelButton, 5);
		assertTrue(schedulePage.cancelButton.isEnabled());
	}



	@When("User clicks on cancel conference button")
	public void user_clicks_on_cancel_conference_button() {
		
		schedulePage.cancelButton.click();

	}


	
	@Then("Reserved {string} should not be displayed in the schedule")
	public void reserved_should_not_be_displayed_in_the_schedule(String roomName) {
		assertTrue(schedulePage.cancelText(roomName).isDisplayed());
		new LoginStepDefs().signOut();
	
		
		
	}
	
}
