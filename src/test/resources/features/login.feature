Feature: Website functionality

  Scenario: Navigation
    Given I navigate to the 'We are Community' website
    When I open the about us page
    Then I should see the contact email
    Then I should exit the browser

  Scenario: Community search
    Given I navigate to the 'We are Community' website
    When I view the 'Communities' section
    And I input "game" to the community search bar
    Then The first community name should be "EPAM GameTech Community"
    And I filter by Hungary,Szeged
    Then The first community name should be "Szeged Board Game Community"
    Then I should exit the browser
