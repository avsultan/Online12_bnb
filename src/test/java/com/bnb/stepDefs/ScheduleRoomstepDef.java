package com.bnb.stepDefs;

import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.bnb.pages.FreeSpotsPage;
import com.bnb.pages.HuntPage;
import com.bnb.pages.LoginPage;
import com.bnb.pages.MapPage;
import com.bnb.pages.RoomSchedulePage;
import com.bnb.pages.SchedulePage;
import com.bnb.utils.BrowserUtils;
import com.bnb.utils.ConfigurationReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ScheduleRoomstepDef {

	LoginPage loginPage = new LoginPage();
	MapPage mapPage = new MapPage();
	SchedulePage schedulePage = new SchedulePage();
	LoginStepDefs loginstepdef = new LoginStepDefs();
	RoomSchedulePage rsch = new RoomSchedulePage();
	HuntPage huntPage = new HuntPage();
	int timeFromIndex;
    int timeTillIndex = 1;
    int emptyDate;
	
	@Given("user logs in with valid credentials")
	public void user_logs_in_with_valid_credentials() {
		loginPage.emailInputBox.sendKeys(ConfigurationReader.getProperty("qa_huntwebsite_valid_username"));
		loginPage.passwordInputBox.sendKeys(ConfigurationReader.getProperty("qa_huntwebsite_valid_password"));
		loginPage.signInButton.click();
		
	}
	@When("user clicks on {string}")
	public void user_clicks_on(String roomName) {
		mapPage.goToRoom(roomName).click();

	}
	@When("user verfies empty date and time on the schedule")
	public void user_verfies_empty_date_and_time_on_the_schedule() {
		String elClass =  "conference";
		
	Outer:for(int j=0; j<=7; j++) {
	 Inner:	for(int i=0; i<30; i++) {
				if(rsch.getAvailableTime(i).get(j).getAttribute("class").equals(elClass) ||
				   rsch.getAvailableTime(i+1).get(j).getAttribute("class").equals(elClass)) {
				
					continue Inner;
			}else {
				timeFromIndex = i+1;
				emptyDate = j;
				break Outer;
			 }
				
	       }
		}
	}

	@When("user hunts for that same date and time in the hunt page")
	public void user_hunts_for_that_same_date_and_time_in_the_hunt_page() {
		huntPage.huntLink.click();
		String today = LocalDate.now().toString();
	    String dateOnly = today.substring(today.length()-2);
	    int targetNumber = Integer.parseInt(dateOnly);
	    
	    Select select1 = new Select(huntPage.timeLineStart);
	    Select select2 = new Select(huntPage.timeLineFinish);
	    
	    huntPage.date.sendKeys( (targetNumber+ emptyDate) + "");
	    select1.selectByIndex(timeFromIndex);
	    select2.selectByIndex(timeTillIndex);
	    
	    BrowserUtils.waitFor(3);
	    huntPage.searchButton.click();
	}

	@Then("user should see {string} name on the list of free spot")
	public void user_should_see_name_on_the_list_of_free_spot(String room) {
       FreeSpotsPage freeSpotPage = new FreeSpotsPage();
	    
	    for (WebElement eachRoom : freeSpotPage.freeRooms) {
			if(eachRoom.getText().equals(room)) {
				assertTrue(eachRoom.isDisplayed());
			}
		}
	    		
	}
	
}
