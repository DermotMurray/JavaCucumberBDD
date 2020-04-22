package StepImplementation;

import POM.DashBoardPage;
import POM.LoginPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class BDDLoginTest {

    WebDriver driver;
    String browser = "chrome";
    String url = "https://the-internet.herokuapp.com/login";

    @Before
    public void setup()
    {
        // Define web driver
        System.out.println("Setting up driver");
        driver = Util.DriverFactory.open(browser);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Given("^user is on the login page$")
    public void user_is_on_the_login_page(){
        System.out.println("User is on the login page");
        driver.get(url);
    }

    @When("^user enters correct username and correct password$")
    public void user_enters_correct_username_and_correct_password() {
        LoginPage loginPage = new LoginPage(driver);

        System.out.println("User enters correct username and correct password");
        loginPage.setUsername("tomsmith");
        loginPage.setPassword("SuperSecretPassword!");
        loginPage.clickSubmit();
    }

    @When("^user enters username(.*)$")
    public void user_enters_username(String username){
        LoginPage loginPage = new LoginPage(driver);

        System.out.println("User enters " + username);
        loginPage.setUsername(username);
    }

    @And("^user enters password(.*)$")
    public void user_enters_password(String password){
        LoginPage loginPage = new LoginPage(driver);

        System.out.println("User enters " + password);
        loginPage.setPassword(password);
    }

    @And("^user clicks login$")
    public void user_clicks_login(){
        LoginPage loginPage = new LoginPage(driver);

        System.out.println("User clicks submit");
        loginPage.clickSubmit();
    }

    @Then("^user gets confirmation$")
    public void user_gets_confirmation(){
        DashBoardPage dashBoardPage = new DashBoardPage(driver);

        System.out.println("User can access Dashboard page");
        String message = dashBoardPage.messageText();
        assertThat(message ,  containsString("You logged into a secure area!"));
    }

    @Then("^user can access Dashboard page$")
    public void user_can_access_Dashboard_page() {
        DashBoardPage dashBoardPage = new DashBoardPage(driver);

        System.out.println("User can access Dashboard page");
        String message = dashBoardPage.messageText();
        assertThat(message ,  containsString("You logged into a secure area!"));
    }

    @After
    public void tearDown()
    {
        //Close Driver
        driver.quit();
    }

}
