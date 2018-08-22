Feature: TestLoginFunctionality
Background:
Given the user goes to the login page 
#@login 
Scenario Outline: 
#	Given the user goes to the login page 
	When User loges in using username "<email>" and password "<password>" 
	Then user should see map and following links 
		|ocean view		|
		|kuzzat's cave	|
		|4stay			|
		|study area		|
		|kitchen		|
		|lobby			|
		|kilimanjaro	|
		|half dome		|
		|denali			|
		|meru			|
		
		
	Examples: 
		| email                           | password          |
		| efewtrell8c@craigslist.org      | jamesmay          |
		| bbursnoll8d@acquirethisname.com | johndillinger     |
		| crundall8e@discuz.net           | eloisamaccauley   |
		#		| emaynell8f@google.es            | besslebond        |
		#		| nyablsley8g@nasa.gov            | huntdurand        |
		#		| jrowesby8h@google.co.uk         | aldridgegrimsdith |
		#		| hsmetoun8i@edublogs.org         | shanecartmale     |
		#		| uklimes8j@goodreads.com         | joyaprowse        |
		#		| bstouther8k@meetup.com          | byranncrowdson    |
		#		| mcossor8l@webmd.com             | cecilnacey        |
		#		| elaye8m@wikipedia.org           | tabordullingham   |
		#		| wfarrell8n@usnews.com           | doniafisby        |
		#		| mnewbatt8o@utexas.edu           | opalcave          |
		#		| wamiss8p@businesswire.com       | olagrills         |
		#		| bmurkus8q@psu.edu               | alicasanbroke     |
		#		| mstacey8r@imdb.com              | skylargiblin      |
		#		| ecrasford8s@dagondesign.com     | bricesiddell      |
		#		| gwilloway8t@nih.gov             | morrievondrach    |
		#		| hurey8u@go.com                  | elenemaynell      |
		#		| dronaghan8v@google.ca           | nonnayablsley     |
		#		| vaughn8w@state.gov              | jojorowesby       |
		#		| anthony8x@ocn.ne.jp             | hernandosmetounk  |
		#		| clementet8y@bluehost.com        | ursalaklimes      |
		#		| tabrett8z@latimes.com           | beveriestouther   |
		#		| braunthal90@reverbnation.com    | mollycossor       |
		#		| greensmith91@nytimes.com        | elbertlaye        |
		#		| arzu92@istockphoto.com          | weidarfarrell     |
		#		| lruffli93@dailymail.co.uk       | menardnewbatt     |
		#		| teachervawiltonamiss@gmail.com  | wiltonamiss       |
		#		| teachervasctoforstall@gmail.com | scottforstall     |
		#		| teachervamikemarcus@gmail.com   | mikemarcus        |
@login
Scenario: Login with invalid username 
#	Given the user goes to the login page
	When the user type "notexisting@email.com" and "password"
	Then message "user with email: notexisting@email.com doesn`t exist." appears on the bottom of the page
@login 
Scenario: Login with invalid password 
#	Given the user goes to the login page
	When the user type "efewtrell8c@craigslist.org" and "password"-(invalid password)
	Then message "invalid password." appears on the bottom of the page-(invalid password)
