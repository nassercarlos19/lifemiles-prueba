package steps;

import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.phatomjs.PhatomJSDriverService;
//import org.openqa.selenium.remote.DesidredCapabilities;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import cucumber.api.Pending;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;

import java.io.File;

import org.junit.Assert;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)


public class TestSteps {
	
	
	WebDriver dr;
	
	@Before
	public void beforeScenario() {
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\zhuezo\\chromedriver_win32\\chromedriver.exe");
		File src = new File("/var/lib/jenkins/phantomjs-2.1.1/bin/phantomjs");
		System.setProperty("phantomjs.binary.path", src.getAbsolutePath());
		dr = new PhantomJSDriver();
		//dr = new ChromeDriver();
		//dr.manage().window().maximize();
	}
	 @Given("^I am in login page \"([^\"]*)\"$")
	 public void i_am_in_login_page(String URL) {
		dr.get(URL); 
		//dr.get("http://104.154.101.157/usuarios/login");
	 }
	 @Given("^I  enter Username as \"([^\"]*)\" and password \"([^\"]*)\" And I press Login$")
	 public void i_enter_username_as_something_and_password_something_and_i_press_login(String user, String pass) throws Throwable {
		 dr.findElement(By.id("username")).sendKeys(user); 
		 dr.findElement(By.id("password")).sendKeys(pass);  
		 dr.findElement(By.className("btn-primary")).submit();
	 
	 }
	 
	 @Then("^Login Success \"([^\"]*)\"$")
	 public void login_success(String URLS) throws Throwable {
		 System.out.println(dr.getCurrentUrl());
		 //Assert.assertTrue(dr.getCurrentUrl().equals("http://localhost:81/usuarios/home"));
		 Assert.assertEquals(URLS,dr.getCurrentUrl());
	 }

	 @Then("^Login Failed \"([^\"]*)\"$")
	 public void login_failed(String URLF) throws Throwable {
		 System.out.println(dr.getCurrentUrl());
		 //Assert.assertEquals("Usuario y/o contraseña incorrecta",dr.findElement(By.id("msg-error")));
		 Assert.assertEquals(URLF,dr.getCurrentUrl());
	 }
	 
	 @After
	 public void afterScenario() {
	    dr.quit();
	 }
}

