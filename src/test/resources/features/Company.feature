Feature: Access company end point /company


  Scenario: GET company details for all data available
    Given I have the valid details to access the company api end point
    When I send a GET request to company end point
    Then  I should recieve a response code as 200
    And response body should contain valid details

  Scenario Outline: GET company details for specific data available
    Given I have the valid details to access the company api end point
    When I send a GET request to company end point
    Then  I should recieve a response code as 200
    Then  I should recieve a response code as 200
    Then response body should contain id <id> for project <project>
    Examples:
      | id | project       |
      | 3  | Project Gamma |


  Scenario: Create company details for all data available
    Given I have the valid details to create a new company
    When I send a POST request to "/company" end point
    Then  I should recieve a response code as 201
    And response body should contain valid details