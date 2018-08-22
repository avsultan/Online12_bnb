package com.bnb.stepDefs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bnb.pages.LoginPage;
import com.bnb.pages.MapPage;
import com.bnb.utils.BrowserUtils;
import com.bnb.utils.Driver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDefs {
	
	static LoginPage loginPage = new LoginPage();
	static MapPage mapPage = new MapPage();
	
	public static void signOut() {
		BrowserUtils.hover(mapPage.myNavBar);
		BrowserUtils.waitFor(2);
		mapPage.signOutButton.click();
	}
	
	@Given("the user goes to the login page")
	public void the_user_goes_to_the_login_page() throws Exception {
	    assertEquals("sign in", loginPage.signInText.getText());
	}

	@When("User loges in using username {string} and password {string}")
	public void user_loges_in_using_username_and_password(String username, String password) {
	    loginPage.emailInputBox.sendKeys(username);
	    loginPage.passwordInputBox.sendKeys(password);
	    loginPage.signInButton.click();
	}
	
	@Then("user should see map and following links")
	public void user_should_see_map_and_following_links(List<String> roomNames) {
		BrowserUtils.explicitWait(9).until(BrowserUtils.textToBeByElement(mapPage.VATitleText, "VA"));
		BrowserUtils.explicitWait(9).until(BrowserUtils.textToBeByElement(mapPage.darkSideSubTitleText, "dark-side"));
		assertEquals("VA", mapPage.VATitleText.getText());
		assertEquals("dark-side", mapPage.darkSideSubTitleText.getText());
		assertEquals(roomNames.size(), mapPage.roomNames.size());
		for (int i = 0; i < roomNames.size(); i++) {
			if(mapPage.roomNames.get(i).getText() == null) {
				BrowserUtils.explicitWait(9).until(BrowserUtils.textToBeByElement(mapPage.roomNames.get(i), "kilimanjaro"));
			} else {
			assertTrue(roomNames.get(i).equals(mapPage.roomNames.get(i).getText()));
			System.out.println(roomNames.get(i) + " : " + mapPage.roomNames.get(i).getText());
			}
		}
	    signOut();
	}
	
	@When("the user type {string} and {string}")
	public void the_user_type_and(String username, String password) {
		loginPage.emailInputBox.sendKeys(username);
	    loginPage.passwordInputBox.sendKeys(password);
	    loginPage.signInButton.click();
	}

	@Then("message {string} appears on the bottom of the page")
	public void message_appears_on_the_bottom_of_the_page(String message) {
		BrowserUtils.explicitWait(9).until(BrowserUtils.textToBeByElement(loginPage.notExistMessage, "user with email: notexisting@email.com doesn`t exist."));
	    assertEquals(message, loginPage.notExistMessage.getText());
	}
	
	@When("the user type {string} and {string}-\\(invalid password)")
	public void the_user_type_and_invalid_password(String username, String password) {
		loginPage.emailInputBox.sendKeys(username);
	    loginPage.passwordInputBox.sendKeys(password);
	    loginPage.signInButton.click();
	}

	@Then("message {string} appears on the bottom of the page-\\(invalid password)")
	public void message_appears_on_the_bottom_of_the_page_invalid_password(String message) {
		BrowserUtils.explicitWait(9).until(BrowserUtils.textToBeByElement(loginPage.notExistMessage, "invalid password."));
	    assertEquals(message, loginPage.notExistMessage.getText());
	}
	
}
