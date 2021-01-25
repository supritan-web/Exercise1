#Author: suprita.nellikeri
Feature: Wikipedia features

  @contents
  Scenario: The headings listed in the `Contents` box are used as headings on the page
    Given user is on Wikipedia page
    When lists contents box
    Then lists are headings on the page

  @contents
  Scenario: The headings listed in the `Contents` box have functioning hyperlinks
    Given user is on Wikipedia page
    When lists contents box
    Then lists are clickable

  @contents
  Scenario: The headings listed in the `Contents` box have functioning hyperlinks
    Given user is on Wikipedia page
    When user hovers over Nike
    Then validate personified concepts
