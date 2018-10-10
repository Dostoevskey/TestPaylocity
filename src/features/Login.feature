@all
Feature: Paylocity employees benefits package

  As a Employer
  I want to add employee
  So that to pay employee's benefits

  @success @regression
  Scenario: Add Employee no Discount
    Given an Employer
    And I am on the Benefits Dashboard page
    When I select Add Employee
    Then I should be able to enter employee details
    And First Name does not begin with "A" or "a"
    And the employee should save
    And I should see the employee in the table
    And the benefit cost calculations are correct

#  @fail @regression
#  Scenario: Add Employee with Discount
#    Given an Employer
#    And I am on the Benefits Dashboard page
#    When I select Add Employee
#    Then I should be able to enter employee details
#    And First Name begins with "A" or "a"
#    And the employee should save
#    And I should see the employee in the table
#    And the employee has a 10% discount
#    And the benefit cost calculations are correct