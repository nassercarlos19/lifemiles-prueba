Feature: LoginDBB

Background: 
	Given I am in login page "http://104.197.75.20/usuarios/login"

Scenario Outline: Login with a valid credentials
	Given I  enter Username as "<username>" and password "<password>" And I press Login
	Then Login Success "http://104.154.101.157/usuarios/home"
	
Examples: sample data
	|username|password|
	|usuario|usuario|
	
Scenario: Login with invalid credentials
	Given I  enter Username as "tesee" and password "test" And I press Login
	Then Login Failed "http://104.197.75.20/usuarios/loginAction"
