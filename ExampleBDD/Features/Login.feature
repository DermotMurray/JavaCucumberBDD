# Each feature file contains one feature (Gherkin)
Feature: Test the login functionality on the internet

  # A feature can have many scenarios (Given - When - Then)
  Scenario: The user should be able to login with correct username and password
    Given user is on the login page
    When user enters correct username and correct password
    Then user can access Dashboard page

      # Parameterised data
    Scenario Outline:  the user should be able to login
      Given user is on the login page
      When user enters username<username>
      And user enters password<password>
      And user clicks login
      Then user gets confirmation

        # Parameters (One pass, Two fail)
      Examples:
      | username | password |
      | dermot   | murray   |
      | murray   | dermot   |
      | tomsmith | SuperSecretPassword! |
