package starter.utils;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FrameUtils {

    /**
     * Switch to iframe by index.
     *
     * @param index index of the iframe.
     */
    @Step("Switch to Frame by Index: {0}")
    public static void switchToFrameByIndex(int index) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(index));
    }

    /**
     * Switch to iframe by name or ID.
     *
     * @param nameOrId the name or ID of the iframe.
     */
    @Step("Switch to Frame by Name or ID: {0}")
    public static void switchToFrameByNameOrId(String nameOrId) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(nameOrId));
    }

    /**
     * Switch to iframe by WebElement.
     *
     * @param frameElement the WebElement representing the iframe.
     */
    @Step("Switch to Frame by WebElement")
    public static void switchToFrameByWebElement(WebElementFacade frameElement) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));
    }

    /**
     * Switch back to the default content (out of all iframes).
     */
    @Step("Switch back to default content")
    public static void switchToDefaultContent() {
        getDriver().switchTo().defaultContent();
    }

    /**
     * Get the current WebDriver instance.
     *
     * @return the current WebDriver instance.
     */
    private static WebDriver getDriver() {
        return Serenity.getDriver();
    }
}
