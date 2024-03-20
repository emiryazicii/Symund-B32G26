Feature: Login function

  @SuccessfulLogin
  Scenario Outline: User can log in with valid credentials
    Given the user logs in with username "<username>" and password "<password>"
    Then the user should be directed to the dashboard

    Examples:
      | username    | password    |
      | Employee10  | Employee123 |
      | Employee30  | Employee123 |
      | Employee40  | Employee123 |
      | Employee50  | Employee123 |
      | Employee60  | Employee123 |
      | Employee70  | Employee123 |
      | Employee80  | Employee123 |
      | Employee90  | Employee123 |
      | Employee110 | Employee123 |
      | Employee120 | Employee123 |
      | Employee130 | Employee123 |
      | Employee140 | Employee123 |
