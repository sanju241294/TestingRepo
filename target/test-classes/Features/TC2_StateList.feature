@StateList
Feature:   StateModule API Automation
Scenario:  Verify User Get StateList through API
Given      User add Headers for StateList
When       User send "GET" request for StateList endPoint
Then       User verify the status code is 200
And        User should verify the StateList response message matches  "35" and saved the StateId