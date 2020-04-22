package Util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public static WebDriver open(String browser)
    {
        if ("firefox".equals(browser)) {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        } else if ("chrome".equals(browser)) {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        } else if ("edge".equals(browser)) {
            WebDriverManager.edgedriver().setup();
            return new EdgeDriver();
        } else {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }
    }
}
