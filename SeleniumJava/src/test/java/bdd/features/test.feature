Feature: Test webpage
  as a user we can select brand
  get prices from different brands

  Scenario: Login with nonexistent user
    Given The webpage "https://subastas.carmatch.mx/login"
    Then I type "a@a.com" user
    And I type "1234" password
    And I login
    Then I should see an error message

  Scenario: Redirect to sell funnel step 2
    Given The webpage "https://carmatch.mx/"
    Then I select brand "Chevrolet"
    And I select the model "Camaro"
    And I select the year "2015"
    Then I click to Cotizacion Gratuita
    Then I verify the brand is the one I selected

  Scenario: Available brands list
    Given The webpage "https://carmatch.mx/"
    Then Get the brand list
    Then Check the brand list is correct