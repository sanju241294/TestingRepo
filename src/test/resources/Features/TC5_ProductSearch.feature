@Search
Feature: Product search module API Automation
   Scenario Outline: verify user get product search through api
     Given user add header for product search
     When user add request body for product search "<text>" 
     And user send "POST" rest for product search endpoint
     Then User verify the status code is 200
     And user should verify the product search response message matches "OK"
     Examples:
     |text|
     |nuts|
     