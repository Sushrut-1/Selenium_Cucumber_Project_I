package hooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class hooks {

    public static WebDriver driver;

    @Before
    public void setup() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        System.out.println("Browser Started");
    }

    @After
    public void tearDown() {

        driver.quit();

        System.out.println("Browser Closed");
    }
}