Feature: Chat with Users
  As a Tinder user
  I want to be able to chat with my matches
  So that I can communicate with them

  Scenario: Viewing the match list
    Given the user has matches
    When the user opens the match list
    Then they should see all their matches

  Scenario: Starting a chat
    Given the user has a match
    When the user starts a chat with the match
    Then they should be able to send a message

  Scenario: Sending a message
    Given the user has a chat with the match
    When the user sends a message
    Then the message should appear in the chat

  Scenario: Deleting a message
    Given the user has a chat with the match
    And the chat contains messages
    When the user deletes a message
    Then the message should be deleted from the chat

  Scenario: Notification for a new message
    Given the user has a match
    When the match sends a new message
    Then the user should receive a notification for the new message
