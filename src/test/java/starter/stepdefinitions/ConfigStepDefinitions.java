package starter.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;
import starter.steps.ConfigStep;
import starter.steps.SearchGoogleStep;
import starter.utils.WaitUtils;

public class ConfigStepDefinitions {
    @Steps
    ConfigStep configStep;
    @Steps
    SearchGoogleStep searchGoogleStep;
    @Given("Open browser")
    public void openBrowser() {
        configStep.open();
    }
    @Given("Navigate to search page")
    public void navigateToSearchPage() {
        searchGoogleStep.openBrowser();
    }
    @After
    public void tearDown() {
        if (Serenity.getDriver() != null) {
            Serenity.getDriver().quit();
        }
    }
}
