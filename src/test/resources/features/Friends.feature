@friend
Feature: Friends API

  Background:
    Given the API is available

  Scenario: Get all friends
    When I send a GET request to "/friends"
    Then the status code should be 200
    And the response should contain a list of friends


  @post  @profile1
  Scenario: Add a new friend
    When I send a POST request to "/friends" with the body from "createFriend.json"
    Then the status code should be 201
    Then the response should contain a list of friends


  @post_with_pojo  @profile1
  Scenario: Add a new friend with POJO
    When I send a POST request with the help of JSON  to "/friends"
    Then the response should contain a list of friends

    #And i fail if strict is true

  Scenario Outline: Verify an email address for specific id from the GET API response
    When I send a GET request to "/friends"
    Then the status code should be 200
    And the response id <id> should have email <email>


    Examples:
      | id | email                  |
      | 2  | jane.smith@example.com |

  @post_with_json_shcema
  Scenario: Add a new friend with POJO
    When I send a POST request with the help of JSON  to "/friends"
    Then the response should contain first_name post_with_json_shcema to "/friends"


  @basicAssertions
  Scenario: Add a new friend with POJO
    When I send a POST request with the help of JSON  to "/friends"
    Then we perform so basic Assertions

  #<id> and <email> are parameters used in the Scenario Outline.
  # in step def: {int} and {string} are placeholders for the parameters id and email respectively.
  #@smoke, @api, @post, and @regression are tags assigned to scenarios.
  #Tags can be single (@api) or multiple (@api @post).
  #@RunWith(Cucumber.class)
  #@CucumberOptions(
  #  features = "src/test/resources/features",
  #  tags = "@api"
  #)
  #public class RunCucumberTest {
  #}
