package com.bnb.runners;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.bnb.utils.Driver;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
	
	@RunWith(Cucumber.class)
	@CucumberOptions(
			/*plugin = {
					"pretty",
					"html:target/default-cucumber-reports", //generates every time we run the cukes runner
					"json:target/cucumber.json"
			
			},*/
			
			tags="@temp",
			features= {"src/test/resources/com/bnb/features"}, 
			glue= {"com/bnb/stepDefs"}
//			,dryRun = true
			)
	public class CukesRunner {

		@AfterClass
		public static void tearDown() {
			if(Driver.getDriver() != null)
				Driver.getDriver().close();
		}
		
		
	}
