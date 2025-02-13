Feature: UI automation of webapp

  Background:
    Given User navigates to the mentioned page

  Scenario: Verify the title of the page
    Then User verifies the title of the page as "The Internet"

    Scenario: Verify A/B testing link
      When User clicks on "A/B Testing" link
      Then User verifies the text on the page as "A/B Test Variation 1"
      And User navigates back to home page

  Scenario: Verify Dropdown selection
    When User clicks on "Dropdown" link
    And User selects "Option 1" from dropdown
    Then User verifies "Option 1" is selected
    And User navigates back to home page

    Scenario: Verify Frames page
      When User clicks on "Frames" link
      Then User Verifies "Nested Frames" ans "iFrame" links are present