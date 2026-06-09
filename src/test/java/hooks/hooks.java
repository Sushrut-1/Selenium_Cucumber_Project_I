package hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario; // Haa import mhatvacha ahe
import io.github.bonigarcia.wdm.WebDriverManager;

/*
 * hooks (Cucumber) - provides thread-safe WebDriver management.
 * - Uses WebDriverManager to resolve driver binaries
 * - Stores driver in ThreadLocal for parallel runs
 * - Exposes a static getDriver() accessor for tests/pages
 */
public class hooks {

    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    @Before
    public void setup() {
        // Ensure the right driver binary is available
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        // add recommended options (can be controlled via properties later)
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-popup-blocking");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        // sensible page load & implicit wait defaults (prefer explicit waits in page objects)
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        DRIVER.set(driver);

        System.out.println("Browser Started: " + Thread.currentThread().getName());
    }

    @After
    public void tearDown(Scenario scenario) { // Ithe 'Scenario' object pass kela
        WebDriver driver = DRIVER.get();
        
        if (driver != null) {
            // =======================================================
            // SCREENSHOT LOGIC FOR FAILED SCENARIOS
            // =======================================================
            if (scenario.isFailed()) {
                try {
                    // Driver la TakesScreenshot madhe cast karun bytes madhe capture karne
                    final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                    
                    // Cucumber chya HTML report madhe direct image attach karne
                    scenario.attach(screenshot, "image/png", "Failed_Step_Screenshot");
                    
                    System.out.println("[FAILED] - Screenshot attached to report for scenario: " + scenario.getName());
                } catch (Exception e) {
                    System.out.println("Screenshot attach karta ala nahi: " + e.getMessage());
                }
            }
            // =======================================================

            driver.quit();
            DRIVER.remove();
        }

        System.out.println("Browser Closed: " + Thread.currentThread().getName());
    }

    // Accessor used by step definitions and page objects
    public static WebDriver getDriver() {
        return DRIVER.get();
    }
}