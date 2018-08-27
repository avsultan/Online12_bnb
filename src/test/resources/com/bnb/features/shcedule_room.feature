Feature: Test Scheduling Process 


Scenario Outline: Verify Empty schedule

Given user logs in with valid credentials
When user clicks on "<room>"
When user verfies empty date and time on the schedule
And user hunts for that same date and time in the hunt page
Then user should see "<room>" name on the list of free spot
            
    Examples:
        |room       |
        |kilimanjaro|
        #|half dome  |
        #|denali     |
        #|meru       |