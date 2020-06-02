@Regression
Feature: Get the latest foreign exchange reference rates 

Background: 
	Given Latest Foreign Exchange rates for Rates API 
	
Scenario: Assert the success status of the response 
	When The API is available as "?base=USD"
	Then API Should respond with status code as 200 
	
	
	
Scenario: Assert the correct response
	When The API is available as "?base=GBP" 
	Then API should give sucessful response as "GBP" 
	
	
	
Scenario: Validate results on providing incorrect/incomplete endpoint 
	When The API is available as "?base=KKR" 
	Then API Should respond with status code as 400 
	And Invalid error Message as "Base 'KKR' is not supported."
	
	
Scenario: Assert the success status response for specific date 
	When The API is available as "/2020-05-29" 
	Then API Should respond with status code as 200 
	
Scenario:
Assert the correct response for specific date
	When The API is available as "/2020-05-29" 
	Then API should give sucessful response as "GBP" 
	
Scenario: Validate future date with present date 
	When The API is available as "/2021-06-01" 
	Then API should return the current date rates