Feature: annotation

Background:
    User navigates to Facebook Given
    I am on the Facebook login page

Scenario:
    When I enter username as "Tom"
    And I enter password as "Jerry"
    The Login should fail

Scenario:
    When I enter username as "Tom"
    And I enter password as "Jerry"
    Then the login should fail
    But Relogin option should be available