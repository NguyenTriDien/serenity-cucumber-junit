package starter.utils;

import net.serenitybdd.core.Serenity;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import net.serenitybdd.core.pages.WebElementFacade;

import java.time.Duration;

public class WaitUtils {

    // Phương thức static để chờ văn bản trong phần tử WebElementFacade
    public static void waitForElementText(String expectedText, WebElementFacade element) {
        WebDriverWait wait = new WebDriverWait(Serenity.getDriver(), Duration.ofSeconds(10));
        wait.withMessage("Không tìm thấy message thỏa mãn").until(
                ExpectedConditions.textToBePresentInElement(element.getWrappedElement(), expectedText));
    }

    // Phương thức static để chờ văn bản trong phần tử WebElement
    public static void waitForElementText(String expectedText, WebElement element) {
        WebDriverWait wait = new WebDriverWait(Serenity.getDriver(), Duration.ofSeconds(10));
        wait.withMessage("Không tìm thấy message thỏa mãn").until(
                ExpectedConditions.textToBePresentInElement(element, expectedText));
    }
    public static void waitForJavaScriptToLoad() {
        WebDriver driver = Serenity.getDriver();
        if (driver == null) {
            throw new IllegalStateException("WebDriver instance is not available.");
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until((ExpectedCondition<Boolean>) d -> {
            JavascriptExecutor js = (JavascriptExecutor) d;
            return js.executeScript("return document.readyState").equals("complete");
        });
    }
}
