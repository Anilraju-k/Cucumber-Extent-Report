Feature: To test FlipKart login

  Scenario Outline: To test login with inproper credentials
    Given I am on Flipkart login page
    When I enter in INvalid username "<username>" and password "<password>"
    And I click on signIN button
    Then error message should be displayed

    Examples: 
      | username              | password |
      | abc@gmail.com         | vggfcgcf |
      | abcddfddgfd@gmail.com | hcgfcf   |
      | ab554trgfc@gmail.com  | cgcgcgcg |
	@login
  Scenario: To test login with proper credentials
    Given I am on Flipkart login page
    When I enter valid username and password
    And I click on signIN button
    Then home page should be displayed
	
  Scenario: To test login with inproper credentials
    Given I am on Flipkart login page
    When I enter in INvalid username "abc@gmail.com" and password "xyzz"
    And I click on signIN button
    Then error message should be displayed

  Scenario: To test login with inproper credentials
    Given I am on Flipkart login page
    When I enter in INvalid username "abcrffsd@gmail.com" and password "xyzz"
    And I click on signIN button
    Then error message should be displayed

  Scenario: To test login with inproper credentials
    Given I am on Flipkart login page
    When I enter in INvalid username "dfgdfgdfgd@gmail.com" and password "xyzz"
    And I click on signIN button
    Then error message should be displayed
