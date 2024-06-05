	
@Login  @Reg
Feature: LoginModule API Automation
Scenario: Get user logToken from login endPoint
Given User add Header
When User add basic authentication for login
And User send "POST" request for login endPoint
Then User verify the status code is 200
And User should verify the login response body firstName As "Chandralekha" and get the login token saved