Feature: LoginDBB

Scenario: Login with a valid credentials
	Given I am in login page
	When I  enter Username as "usuario" and password "usuario"
	And I press Login
	Then I should go to "usuarios/home"

Scenario: Login failed
	Given I am in login page
	When I have entered invalid Username as "234sdfss" and invalid password as "234sdfss"
	And I press Login
	Then I should go to "/usuarios/loginAction"
