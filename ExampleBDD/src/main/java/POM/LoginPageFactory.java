package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageFactory {

    WebDriver driver;

    @FindBy(id = "username")
    WebElement usernameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(xpath = "//i")
    WebElement loginButton;

    public LoginPageFactory(WebDriver driver){

        // Construct driver
        this.driver = driver;

        // Elements
        PageFactory.initElements(driver, this);

        // Wait
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
    }

    /*
        Steps
    */


    //Setting Username
    public void setUsername(String username){
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    //Setting Password
    public void setPassword(String password){
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    // Clicking Submit Button
    public void clickSubmit(){
        loginButton.click();
    }


    /*
        Actions
    */


    //Login
    public void login(String username, String password){
        setUsername(username);
        setPassword(password);
        clickSubmit();
    }

}
