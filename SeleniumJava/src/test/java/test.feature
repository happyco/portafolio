Feature: Failed login
  as a user

  Scenario: Login
    Given I go to "https://subastas.carmatch.mx/login"
    Then I type "test@test.com" user
    And I type "1234" password
    And I login
    Then I should see an error message