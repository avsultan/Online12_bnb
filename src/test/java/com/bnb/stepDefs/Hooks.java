package com.bnb.stepDefs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.bnb.utils.ConfigurationReader;
import com.bnb.utils.Driver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	@Before
	public void setUp() {
		Driver.getDriver().manage().timeouts().implicitlyWait(9, TimeUnit.SECONDS);
		Driver.getDriver().manage().window().maximize();
		Driver.getDriver().get(ConfigurationReader.getProperty("url"));
	}

	@After
	public void tearDown(Scenario scenario) {
		// only takes a screenshot if the scenario fails
		if (scenario.isFailed()) {
			// taking a screenshot
			final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
			// adding the screenshot to the report
			scenario.embed(screenshot, "image/png");
		}
	}
	

}
