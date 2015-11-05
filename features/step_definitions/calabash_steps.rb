require 'calabash-android/calabash_steps'

Given /^I am on the Login Page$/ do
macro 'I wait for the "MainActivity" screen to appear'
macro 'I press the "Login" button'
macro 'I wait for the view with id "fragment_login" to appear'
end

Then /^I hide the keyboard$/ do
hide_soft_keyboard()
end

Given /^I am on the Landing Page$/ do
    nil
end

Given /^I am logged in for less than an hour$/ do
    nil
end

Given /^I am logged in for more than an hour$/ do
    nil
end

