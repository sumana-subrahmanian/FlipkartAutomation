Feature: To validate the Flipkart functionality

Background:

Given To launch the browser and enter url

When  Enter text in the search field

Then  Search the result should get displayed 


@tc002 
Scenario: To validate search functionality with different values 

Given Launch the browser and enter url

When  Enter "<text>" in the search field

Then  Search  result should get displayed 
And  Take screenshot then close browser

Examples:
|text|
|Shirt|
|Kids Toys|
|TV|


@tc003 @smoke
Scenario: To validate filter option in flipkart 

Given Initialize the filter class

When Filter based on brand
Then   Filter based on RAM
And Take screenshot and close

@tc004 @smoke
Scenario: To select searched result 

Given Initialize the result page class

When  Click on the result and change the window
Then  Get product name
And Close browser aafter taking screenshot

@tc005 @smoke
Scenario: To validate add to cart funtionality 

Given Initialize the addtoCart class

When Add to cart
Then Take Screenshot then close browser
