package com.bnb.stepDefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.bnb.pages.HuntPage;
import com.bnb.pages.SchedulePage;
import com.bnb.utils.BrowserUtils;
import com.bnb.utils.Driver;
public class FunctionalitiesStepDefs {
	SchedulePage schedulePage = new SchedulePage();
	HuntPage huntPage = new HuntPage();

	@When("user navigates to schedule page")
	public void user_navigates_to_schedule_page() {
		schedulePage.scheduleLink.click();
	}

	@When("user clicks on scheduled conference from schedule")
	public void user_clicks_on_scheduled_conference_from_schedule() {
		schedulePage.reservedRoom.click();
	}

	@When("user clicks cancel conference button")
	public void user_clicks_cancel_conference_button() {
		BrowserUtils.waitFor(1);
		schedulePage.cancelButton.click();
	}

	@Then("scheduled conference should not be displayed or clickable anymore")
	public void scheduled_conference_should_not_be_displayed_or_clickable_anymore() {
		
		Boolean isPresent = Driver.getDriver().findElements(By.xpath("//td[@class='conference ng-star-inserted']")).size() > 0;
		assertFalse(isPresent);
	}
	
	@Given("user click on search button and books the room")
	public void user_click_on_search_button_and_books_the_room() {
		new SmokeTestStepDefs().user_clicks_search_button();
		new SmokeTestStepDefs().user_clicks_book_button_under_table_and_clicks_confirm_button("kilimanjaro");
	}
	
	@When("user goes back to hunt page")
	public void user_goes_back_to_hunt_page() {
		BrowserUtils.waitFor(2);
		huntPage.huntLink.click();
	}

	@When("user chooses same date and time and click on search button")
	public void user_chooses_same_date_and_time_and_click_on_search_button() {
		BrowserUtils.waitFor(5);
		huntPage.date.sendKeys("25");
		huntPage.selectTimeStart().selectByVisibleText("8:00am");
		huntPage.selectTimefinish().selectByVisibleText("9:00am");
		huntPage.searchButton.click();

	}
	


	@Then("{string} message should be displayed")
	public void message_should_be_displayed(String expectedText) {
		String actualText = huntPage.alreadyReservedText.getText();
	   assertEquals(expectedText, actualText);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
