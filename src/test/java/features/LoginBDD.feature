Feature: LoginDBB

Background: 
	Given I am in login page "http://104.197.75.20/usuarios/login"

Scenario Outline: Login with a valid credentials
	Given I  enter Username as "usuario" and password "usuario" And I press Login
	Then Login Success "http://104.154.101.157/usuarios/home"
	

	
Scenario: Login with invalid credentials
	Given I  enter Username as "tesee" and password "test" And I press Login
	Then Login Failed "http://104.197.75.20/usuarios/loginAction"
