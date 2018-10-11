@all
Feature: Paylocity employees benefits package

  As a Employer
  I want to add employee
  So that to pay employee's benefits

  @success
  Scenario: Add Employee no Discount
    Given Navigate to the login page
    And Login as Employer
    When I select Add Employee
    Then I should be able to enter employee details
    And First Name does not begin with "A" or "a"
    And the employee should save
    And I should see the employee in the table
    And the benefit cost calculations are correct
