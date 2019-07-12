@runExercise1
Feature: Exercise01

  Scenario: Home and different elements page test
    Given I am on the JDI Index Page
    When I login as
      | epam | 1234 |
    # TODO Test failed
    Then User name should be 'PITER CHAILOVSKII'
    # TODO on which page should be these elements
    And 4 pictures should be displayed
    And 4 texts under pictures should be displayed
    And Two headers above pictures are displayed

    When I click 'Service' top menu button
    Then Dropdown list should be displayed
    And Dropdown list should have
      | SUPPORT | DATES | COMPLEX TABLE | SIMPLE TABLE | TABLES WITH PAGES | DIFFERENT ELEMENTS |
    When I click 'Service' left menu button
    Then Dropdown list should be displayed
    And Left side dropdown menu should have
      | Support | Dates | Complex Table | Simple Table | Tables With Pages | Different Elements |

    When I click 'Different Elements' dropdown menu button
    Then Different Elements page should open
    And Different Elements page should contain 4 checkboxes
    And Different Elements page should contain 4 radiobuttons
    And Different Elements page should contain 2 buttons
    And Different Elements page should contain 1 select
    And Different Elements page should contain left section
    And Different Elements page should contain right section

    When I click on checkboxes
      | Water | Wind |
    Then Checboxes are selected
      | Water | Wind |
    And Log lines for each selected checkbox are present
      | Water | Wind |
    When I click on radiobutton 'Selen'
    # TODO Undefined steps
    Then Radiobutton 'Selen' is selected
    And Log line for radiobutton 'Selen' is present
    When I select in dropdown 'Yellow'
    Then Value 'Yellow' is selected
    And Log line for 'Yellow' value is present
    When I click on checkboxes
      | Water | Wind |
    Then Checboxes are unselected
      | Water | Wind |
    And Log lines for each unselected checkbox are present
      | Water | Wind |