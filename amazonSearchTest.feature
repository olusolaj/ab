Feature: Amazon
description: This test is to test the Search Functionality on Amazon by searching the keyword "Dash Tag" and then click ont the first item

Scenario: Successful click on first search item 
Given User is on Home Page 
Then User search for the item 
When User click the first item to check the price
Then Display a successful message