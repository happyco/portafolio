Feature: Failed login
  as a user
  
  Scenario: Login
    Given I go to "https://subastas.carmatch.mx/login"
    Then I type "<string>" user
    And I type "<string>" password
    And I login
    Then I should see an error message