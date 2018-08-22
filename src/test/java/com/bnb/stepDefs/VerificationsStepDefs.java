package com.bnb.stepDefs;

import static org.junit.Assert.assertEquals;

import javax.security.auth.login.Configuration;

import com.bnb.pages.LoginPage;
import com.bnb.pages.MapPage;
import com.bnb.pages.SchedulePage;
import com.bnb.utils.BrowserUtils;
import com.bnb.utils.ConfigurationReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class VerificationsStepDefs {
	LoginPage loginPage = new LoginPage();
	MapPage mapPage = new MapPage();
	SchedulePage schedulePage = new SchedulePage();
	LoginStepDefs loginstepdef = new LoginStepDefs();

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

	@Then("user should see daily schedule for selected {string}")
	public void user_should_see_daily_schedule_for_selected(String expectedTitle) {
		BrowserUtils.waitFor(2);
		String actualTitle = schedulePage.title.getText();
		assertEquals(expectedTitle, actualTitle);
		BrowserUtils.waitFor(1);
		loginstepdef.signOut();
	}

	@When("user clicks schedule link")
	public void user_clicks_schedule_link() {
		BrowserUtils.waitFor(1);
		schedulePage.scheduleLink.click();
	}

	@Then("user's {string} and {string}  should be displayed")
	public void user_s_and_should_be_displayed(String firstname, String lastname) {
		String expectedFullName = firstname+" "+lastname;
		schedulePage.getFullName(expectedFullName);
		assertEquals("name: "+firstname+" "+lastname+" was not found",expectedFullName, schedulePage.getFullName(expectedFullName));
		BrowserUtils.waitFor(1);
		loginstepdef.signOut();
	}

}
