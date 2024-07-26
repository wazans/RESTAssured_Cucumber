Feature: comments API end to end  /comments

  Scenario: Verify the GET API for comments
    Given I have the valid details to access the comments api end point
    When I paas the url of the comments API in the request
    #Then  I should recieve a response code as 200



  Scenario Outline: Verify a specific comment from the GET API response
    Given I have the valid details to access the comments api end point
    When I paas the url of the comments API in the request
    #Then  I should recieve a response code as 200
    And the comment with id <commentId> should have body "<content>"


    Examples:
      | commentId | content                                       |
      | 2         | This helped me understand JSON server better. |


