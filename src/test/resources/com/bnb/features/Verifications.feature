Feature: Verify 

Scenario Outline: Verify schedule of the rooms visibility 

	Given user logs in with valid credentials 
	When user clicks on "<room>" 
	Then user should see daily schedule for selected "<room>" 
	
	Examples: 
		|room         |
		|kilimanjaro  |
		|half dome    |
		|denali       |
		|meru         |
		
		
		@temp
		Scenario Outline: Verify personal schedule 
			
			Given User loges in using username "<email>" and password "<password>" 
			When user clicks schedule link 
			Then user's "<firstname>" and "<lastname>"  should be displayed
			
				Examples: 
		| email                           |firstname|lastname |password       |
		| efewtrell8c@craigslist.org      |James    |May      |jamesmay       |
		| bbursnoll8d@acquirethisname.com |John     |Dillinger|johndillinger  |
		| crundall8e@discuz.net           |Eloisa   |MacCauley|eloisamaccauley|