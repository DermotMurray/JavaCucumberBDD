package Tests;

import POM.DashBoardPage;
import POM.LoginPage;
import POM.LoginPageFactory;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

public class LoginTest extends BaseTest {


    // Test Method
    @Test(dataProvider = "getData")
    public void loginTestText(String username , String password) {

        // Arrange
        LoginPage loginPage = new LoginPage(driver);
        DashBoardPage dashBoardPage = new DashBoardPage(driver);

        // Act
            loginPage.setUsername(username);
            loginPage.setPassword(password);
            loginPage.clickSubmit();
        String message = dashBoardPage.messageText();

        // Assert
        assertThat(message ,  containsString("You logged into a secure area!"));
    }


    // Test Method
    @Test(dataProvider = "getData")
    public void loginTestDisplayed(String username , String password) {

        // Arrange
        LoginPageFactory loginPageFactory = new LoginPageFactory(driver);
        DashBoardPage dashBoardPage = new DashBoardPage(driver);

        // Act
        loginPageFactory.login(username,password);
        boolean message = dashBoardPage.messageIsDisplayed();

        // Assert
        assertThat(message ,  is(true));
    }


    // Method to pass parameters into class via constructor
    @DataProvider
    public Object[] getData() {
        return Util.Excel.get("src/main/resources/correctUsername.xls");
    }

}
