Feature: Creating and updating repo in github



  @create_repo_git
  Scenario Outline: Create a git hub repo
    Given user has valid git credentials to access git hub URI
    When i request to create new details
    #Then i should be able to validate all required details
    Then player <player> should have an average of average <expectedAverage>
    Examples:
      | player            | expectedAverage |
      | Virat Kohli       | 37.39   |
      | Shikhar Dhawan    | 35.57   |
      | David Warner      | 41.54   |
      | KL Rahul          | 30.05   |
      | Chris Gayle       | 39.72   |
      | AB de Villiers    | 39.71   |

