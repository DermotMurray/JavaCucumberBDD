package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashBoardPage {

    WebDriver driver;
    WebElement successMessage;

    public DashBoardPage(WebDriver driver){

        // Construct driver
        this.driver = driver;

        // Elements
        successMessage = driver.findElement(By.id("flash"));
    }

    /* Return Text of message */
    public String messageText(){
        return successMessage.getText();
    }

    /* Return if message is displayed */
    public boolean messageIsDisplayed(){
        return successMessage.isDisplayed();
    }

}