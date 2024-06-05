@ChangeProfile
Feature:  Change Profile Picture API Automation
Scenario: Verify the change profile picture through API
Given     User add Headers to get change profile picture
When      User add form data to change the profile picture
And       User send "POST" request for change profile picture endPoint
Then      User verify the status code is 200
And       User should verify the change profile response message matches "Profile updated Successfully"