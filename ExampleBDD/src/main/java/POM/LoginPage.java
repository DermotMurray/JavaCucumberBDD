package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    WebDriver driver;
    WebElement usernameField;
    WebElement passwordField;
    WebElement loginButton;

    public LoginPage(WebDriver driver){

        // Construct driver
        this.driver = driver;

        // Elements
        usernameField = driver.findElement(By.id("username"));
        passwordField = driver.findElement(By.id("password"));
        loginButton = driver.findElement(By.xpath("//i"));

        // Wait
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
    }

    /* Setting Username */
    public void setUsername(String username){
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    /* Setting Password */
    public void setPassword(String password){
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    /* Clicking Submit Button */
    public void clickSubmit(){
        loginButton.click();
    }

}
