@smoke
Feature: Trello APIs With Different requests


  Scenario: Create a new organization (workspace)
    Given  implementing trello API to create new workspace
    When Using POST request with the specified authorization
    Then receive expected response will result 200 ok


  Scenario: Get Organizations for a member
    Given  using GET request to get member id
    When  implementing trello API to Get existing workspace
    And using GET request with specified authorization
    Then  receive expected organization response will result 200 ok


  Scenario: Create a board inside an organization
    Given  implementing trello API to create new board in existing workspace
    When  using POST request with required board creating parameters
    Then  receive expected board response will result 200 ok


  Scenario: Get boards in an organization
    Given implementing trello API to Get existing board in specific work space
    When Using GET request with the specified authorization for existing board
    Then receive created board expected response will result 200 ok


  Scenario: Create a new list
    Given implementing trello API to create new list
    When  using POST request to create alist in existing board & organization
    Then  receive expected list response will result 200 ok


  Scenario: Get all lists on a board
    Given implementing trello API to get all lists on board
    When  using GET request to view all existing lists on board
    Then receive expected all list response will result 200 ok


  Scenario: Archive a list
    Given implementing trello API to Archive new workspace
    When using PUT request to update a status of a list to be archived
    Then receive expected archive response will result 200 ok


  Scenario: Delete a board
    Given implementing trello API to Delete an existing board
    When using DELETE request to delete an existing board
    Then receive expected delete response will result 200 ok


  Scenario: Delete an organization
    Given implementing trello API to Delete an existing workspace
    When  using DELETE request to delete an existing Organization
    Then receive expected delete workspace response will result 200 ok
