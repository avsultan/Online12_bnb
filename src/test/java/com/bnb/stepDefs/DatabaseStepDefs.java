package com.bnb.stepDefs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

import com.bnb.pages.LoginPage;
import com.bnb.pages.MapPage;
import com.bnb.pages.SchedulePage;
import com.bnb.pages.SelfPage;
import com.bnb.pages.TeamPage;
import com.bnb.utils.BrowserUtils;
import com.bnb.utils.DBUtils;
import com.bnb.utils.Driver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DatabaseStepDefs {
	
	LoginPage loginPage = new LoginPage();
	MapPage mapPage = new MapPage();
	SchedulePage schedulePage = new SchedulePage();
	LoginStepDefs loginstepdef = new LoginStepDefs();
	SelfPage selfPage = new SelfPage();
	TeamPage teamPage = new TeamPage();
	DBUtils dbu = new DBUtils();
	
	List<String> teamMemebersNamesFromsWebSite = new ArrayList<>();
	List<String> teamMemebersNamesFromDatabase = new ArrayList<>();
	
	@When("user navigates to {string} page")
	public void user_navigates_to_page(String teamPage) {
		BrowserUtils.hover(mapPage.myNavBar);
	    mapPage.team.click();
	    BrowserUtils.waitFor(1);
	    assertEquals(new TeamPage().title.getText(), "team");
	}

	@Then("all team members should be displayed")
	public void all_team_members_should_be_displayed() {
	    for (int i = 0; i < teamPage.names.size(); i++) {
			assertTrue(teamPage.names.get(i).isDisplayed());
			teamMemebersNamesFromsWebSite.add(teamPage.names.get(i).getText());i++;
		}
	}

	@Then("verify all team members names with database {string}")
	public void verify_all_team_members_names_with_database(String firstName) {
		dbu.createConnection();
		int team_id = Integer.parseInt(dbu.getColumnData("select team_id from users where firstname='" + firstName + "';" , "team_id").get(0));
		teamMemebersNamesFromDatabase = dbu.getColumnData("select firstname||' '||lastname as column from users where team_id=" + team_id + ";" , "column");
	    assertEquals(teamMemebersNamesFromDatabase, teamMemebersNamesFromsWebSite);
	    loginstepdef.signOut();
	}
	
	@Then("compare all info from page with database, connect using {string}")
	public void compare_all_info_from_page_with_database_connect_using(String email) {
		dbu.createConnection();
		String query= "select firstname||' '||lastname, role, name, batch_number, c.location from users u\r\n" + 
				"join team t on u.team_id = t.id \r\n" + 
				"join campus c on t.campus_id = c.id \r\n"
				+ "where email = '" + email + "';";
		String infoFromDB = dbu.getQueryResultList(query).toString().replaceAll("[^0-9a-zA-Z, -]", "");
		String infoFromWS = selfPage.name.getText() + ", " + selfPage.role.getText() + ", " + selfPage.team.getText() + ", " + selfPage.batch.getText().substring(1) + ", " + selfPage.campus.getText();
		System.out.println(infoFromWS + "\n" + infoFromDB);
		assertEquals(infoFromWS, infoFromDB);
		loginstepdef.signOut();
	}

}
