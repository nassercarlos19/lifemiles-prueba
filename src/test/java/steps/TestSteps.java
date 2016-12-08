package steps;

import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.FirefoxDriver; 

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)


public class TestSteps {
	
	WebDriver dr;
	
	 @Given("^I am in login page$")
	 public void i_am_in_login_page() {
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\zhuezo\\chromedriver_win32\\chromedriver.exe");
		dr = new ChromeDriver();
		
		//dr = new FirefoxDriver();
		dr.manage().window().maximize();
		dr.get("http://104.154.101.157/usuarios/login"); 
	 }

	 
	 @When("^I  enter Username as \"([^\"]*)\" and password \"([^\"]*)\"$")
	 public void i_enter_username_as_something_and_password_something(String strArg1, String strArg2) {
		 dr.findElement(By.id("username")).sendKeys(strArg1); 
		 dr.findElement(By.id("password")).sendKeys(strArg2);
	 }
	 
	 @And("^I press Login$")
	 public void i_press_login() {
	    dr.findElement(By.className("btn-primary")).click();
	 }

	 @Then("^I should go to \"([^\"]*)\"$")
	 public void i_should_go_to_something(String strArg1) {
	    /*if (dr.getCurrentUrl().equals("http://localhost:81/usuarios/home")) {
				 System.out.println("Test1 Pass"); 
	    } else {
	    	if  (dr.getCurrentUrl().equals("http://localhost:81/usuarios/loginAction")) {
	    		System.out.println("Test2 Pass"); 
			} else {
				System.out.println("Test Failed");
			}
	    }
	 	*/
	 }
	   
	 @When("^I have entered invalid Username as \"([^\"]*)\" and invalid password as \"([^\"]*)\"$")
	 public void i_have_entered_invalid_username_as_something_and_invalid_password_as_something(String strArg1, String strArg2) {
		 dr.findElement(By.id("username")).sendKeys(strArg1); 
		 dr.findElement(By.id("password")).sendKeys(strArg2);
	 }

	    
	    
}

