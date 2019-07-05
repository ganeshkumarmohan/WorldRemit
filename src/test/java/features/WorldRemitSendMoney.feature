@WorldRemit-SendMoneyOnline
Feature: WorldRemit Send Money

  @PassingScenario
  Scenario: Navigate to Money Transfer Page
    Given I navigate to WorldRemit home page
    When I select country Philippines
    And I start the money sending process
    Then I should see the Money Transfer Page for Philippines

  @FailingScenario
  Scenario: Navigate to Money Transfer Page
    Given I navigate to WorldRemit home page
    When I select country Philippines
    And I start the money sending process
    Then I should see the Money Transfer Page for New Zealand

  @ScenarioOutlineDemonstration
  Scenario Outline: Navigate to Money Transfer Page
    Given I navigate to WorldRemit home page
    When I select country <country>
    And I start the money sending process
    Then I should see the Money Transfer Page for <country>
    Examples:
      | country     |
      | Philippines |
      | Brazil      |
      | Australia   |
