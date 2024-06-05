@CityList
Feature: CityModule API Automation
Scenario: Verify User Get CityList through API
Given    User add Headers to get CityList
When     User add request body stateId to get cityList
And      User send "POST" request for CityList endPoint
Then     User verify the status code is 200
And      User should verify the CityList response message matches  "3559" and saved the CityId