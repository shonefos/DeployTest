package infrastructure.driver;

import cucumber.api.java.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import cucumber.api.Scenario;

public class TearDown {

    private WebDriver driver;

    public TearDown() { this.driver = Setup.driver; }

    @After
    public void quitDriver(Scenario scenario) {
        if(scenario.isFailed()) {
            saveScreenshotsForScenario(scenario);
        }
        this.driver.quit();
    }

    private void saveScreenshotsForScenario(final Scenario scenario) {
        final byte[] screenshot = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.BYTES);
        scenario.embed(screenshot, "");
    }
}


