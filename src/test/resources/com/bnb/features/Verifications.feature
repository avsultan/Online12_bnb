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
		
		
Scenario Outline: Verify personal schedule 

	Given User loges in using username "<email>" and password "<password>" 
	When user clicks schedule link 
	Then user's "<firstname>" and "<lastname>"  should be displayed 
	
	Examples: 
		| email                           |firstname|lastname |password       |
		| efewtrell8c@craigslist.org      |James    |May      |jamesmay       |
		| bbursnoll8d@acquirethisname.com |John     |Dillinger|johndillinger  |
		| crundall8e@discuz.net           |Eloisa   |MacCauley|eloisamaccauley|
		
		
Scenario Outline: Verify myself page 

	Given User loges in using username "<username>" and password "<password>" 
	When user goes to my self page 
	Then page should display "<name>" and "<team>" and "<role>": 
	
	Examples: 
		|username                      |password     |name          |team       |role               |
		|efewtrell8c@craigslist.org    |jamesmay     |James May     |HighTech   |student-team-member|
		|mcossor8l@webmd.com           |cecilnacey   |Cecil Nacey   |Rangers    |student-team-leader|
		|teachervamikemarcus@gmail.com |mikemarcus   |Mike Marcus   |Teachers   |teacher            |
		
		
Scenario Outline: Verify team members with database 

	Given User loges in using username "<username>" and password "<password>" 
	When user navigates to "my-team" page 
	Then all team members should be displayed 
	And verify all team members names with database "<first_name>" 
	
	Examples: 
		|username                      		|password     		|first_name	|
		|emaynell8f@google.es    			|besslebond     	|Bess		|
		|mcossor8l@webmd.com    			|cecilnacey     	|Cecil		|
		|wfarrell8n@usnews.com   			|doniafisby   		|Donia		|
		|efewtrell8c@craigslist.org 		|jamesmay    		|James		|
		|bbursnoll8d@acquirethisname.com    |johndillinger      |John		|
		|crundall8e@discuz.net  			|eloisamacculey  	|Eloisa		|
		
	
Scenario Outline: Verify user info from self page with database 

	Given User loges in using username "<username>" and password "<password>" 
	When user goes to my self page 
	Then compare all info from page with database, connect using "<username>" 
	
	Examples: 
		|username                      		|password     		|
		|emaynell8f@google.es    			|besslebond     	|
		|efewtrell8c@craigslist.org 		|jamesmay    		|
		
		
		
		