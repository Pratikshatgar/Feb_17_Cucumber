Feature: Login page Feature

@Smoke @Regression
Scenario: Validate login
Given User is on login Page and it is already resistered
Then Username field is displayed 
And Continue button is displayed
When user enters Username 
And Click on Continue button
Then Password field is displayed
And Amazon Logo is displayed
And ForgotPassword link is displayed
And Keep me signed in checkbox is displayed
And Sign In button is displayed
When user enters Password 
And Click on SignIn button
#Then All button is displayed