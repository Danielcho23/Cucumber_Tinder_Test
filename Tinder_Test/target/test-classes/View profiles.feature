Feature: Viewing Profiles
  As a user of Tinder
  I want to be able to view profiles of other users
  So that I can decide whether to like them or not

  Scenario: Viewing a Profile
    Given the user is logged in the system
    When the user views a profile
    Then they should see the profile information

  Scenario: Liking a Profile
    Given the user is logged in the system
    And they are viewing a profile
    When the user likes the profile
    Then the profile should be added to the liked profiles list

  Scenario: Disliking a Profile
    Given the user is logged in the system
    And they are viewing a profile
    When the user dislikes the profile
    Then the profile should not be added to the liked profiles list

  Scenario: Mutual Liking
    Given user A likes user B
    And user B likes user A
    When a match is created between user A and user B
    Then there should be a match between user A and user B

  Scenario: Notification for a Match
    Given there is a match between user A and user B
    Then both users should receive a match notification
