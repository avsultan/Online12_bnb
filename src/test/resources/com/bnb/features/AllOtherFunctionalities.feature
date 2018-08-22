Feature: Test functionalities of the website 


Background: 
	Given User logs in as a teacher with user name "teachervamikemarcus@gmail.com" and password "mikemarcus" 
	
	
Scenario: Cancel functionality 
	And User goes to hunt page and selects "25" and time from "8:00am" to "9:00am" 
	When user navigates to schedule page 
	And user clicks on scheduled conference from schedule 
	And user clicks cancel conference button 
	Then scheduled conference should not be displayed or clickable anymore 
	
	
	
	
Scenario: Hunt functionality (Negative) 
	And User goes to hunt page and selects "25" and time from "8:00am" to "9:00am" 
	And user click on search button and books the room 
	When user goes back to hunt page 
	And user chooses same date and time and click on search button 
	Then "you already have a conference for 2018-08-25." message should be displayed 
	
	
	
	