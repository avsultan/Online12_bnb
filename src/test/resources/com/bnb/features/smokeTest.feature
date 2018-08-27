Feature: Smoke Test 


Scenario Outline:  Smoke Test
	Given User logs in as a teacher with user name "teachervamikemarcus@gmail.com" and password "mikemarcus" 
#	And   User clicks on  "<room>" and check for empty spot 
	And   User goes to hunt page and selects "25" and time from "8:00am" to "9:00am" 
	When User clicks search button 
	Then "<room>" name should be displayed 
	When User clicks book button under "<room>" table and clicks confirm button 
	Then User should see user's schedule 
	When User click on reserved date and time appeared on the schedule 
	Then cancel conference button should be clickable 
	When User clicks on cancel conference button 
	Then Reserved "<room>" should not be displayed in the schedule 
	
	Examples: 
		|room       |
		|kilimanjaro|
		|half dome  |
		|denali     |
		|meru       |