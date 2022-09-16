Feature: As a business user of the Payback Mobile application I want to validate 
the activate coupon functionality
					 
Scenario: Verify that user is able to filter the coupon as per partner name and is able to activate the first enabled coupon
Given user has freshly installed the Payback android application
When user open the Payback application
And user log in to the application
Then an error message should be displayed to the user
When user navigates to the coupon center
And user filter the coupon by PartnerName
And user activate the first enabled coupon
Then user should be able to activate the coupon
