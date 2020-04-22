package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    WebDriver driver;
    String browser = "chrome";
    String url = "https://the-internet.herokuapp.com/login";

    @BeforeMethod
    public void setup()
    {
        // Define web driver
        driver = Util.DriverFactory.open(browser);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
    }

    @AfterMethod
    public void tearDown()
    {
        //Close Driver
        driver.close();
    }

    @AfterTest
    public void testTearDown()
    {
        //Quit Driver
        driver.quit();
    }

}
