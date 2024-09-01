package starter.utils;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.ListOfWebElementFacades;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import net.serenitybdd.core.pages.WebElementFacade;

import java.time.Duration;

public class KeyWord {
    public static void waitForPageLoaded() {
        WebDriverWait wait = new WebDriverWait(Serenity.getDriver(), Duration.ofSeconds(1000), Duration.ofMillis(500));
        JavascriptExecutor js = (JavascriptExecutor) Serenity.getDriver();

        // wait for Javascript to loaded
        ExpectedCondition<Boolean> jsLoad = driver -> {
            assert driver != null;
            return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
        };

        //Get JS is Ready
        boolean jsReady = js.executeScript("return document.readyState").toString().equals("complete");

        //Wait Javascript until it is Ready!
        if (!jsReady) {
            System.out.println("Javascript in NOT Ready!");
            //Wait for Javascript to load
            try {
                wait.until(jsLoad);
            } catch (Throwable error) {
                error.printStackTrace();
                Assert.fail("Timeout waiting for page load. (" + Duration.ofSeconds(1000) + "s)");
            }
        }
    }
    public static void sleep(Integer second) {
        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static boolean selectOptionDynamic(WebElementFacade elementFacade, String text, String tagName) {
        // For dynamic dropdowns (div, li, span,...not select options)
        try {
            ListOfWebElementFacades elements = elementFacade.thenFindAll(By.tagName(tagName)); // Hoặc sử dụng tag phù hợp

            for (WebElementFacade element : elements) {
                if (element.getText().toLowerCase().trim().contains(text.toLowerCase().trim())) {
                    element.waitUntilClickable().click();
                    return true;
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return false;
    }
    @Step("Verify Option Dynamic Exist by Text {0}")
    public static boolean verifyOptionDynamicExist(WebElementFacade elementFacade, String text) {

        try {
            ListOfWebElementFacades elements = elementFacade.thenFindAll("li"); // Tùy vào cấu trúc của dropdown mà có thể cần thay đổi selector

            for (WebElementFacade element : elements) {
                if (element.getText().toLowerCase().trim().contains(text.toLowerCase().trim())) {
                    return true;
                }
            }
        } catch (Exception e) {
           e.getMessage();
        }
        return false;
    }
    @Step("Get total of Option Dynamic with list element {0}")
    public static int getOptionDynamicTotal(WebElementFacade elementFacade) {
        try {
            ListOfWebElementFacades elements = elementFacade.thenFindAll("li"); // Tùy vào cấu trúc của dropdown mà có thể cần thay đổi selector
            return elements.size();
        } catch (Exception e) {
         e.getMessage();
        }
        return 0;
    }

    /**
     * Khi dùng có the dùng trực tiếp khi có WebElementFacade
     *
     * @param elementFacade
     * @param text
     */
    @Step("Select Option by Text {0}")
    public static void selectOptionByText(WebElementFacade elementFacade, String text) {
        elementFacade.selectByVisibleText(text);
    }
    @Step("Select Option by Value {0}")
    public static void selectOptionByValue(WebElementFacade elementFacade, String value) {
        elementFacade.selectByValue(value);
    }
    @Step("Select Option by index {0}")
    public static void selectOptionByIndex(WebElementFacade elementFacade, Integer index) {
        elementFacade.selectByIndex(index);
    }
    @Step("Click Accept on Alert")
    public static void acceptAlert() {
        sleep(1000);
        Serenity.getDriver().switchTo().alert().accept();
    }
    @Step("Click Dismiss on Alert")
    public static void dismissAlert() {
        sleep(1000);
        Serenity.getDriver().switchTo().alert().dismiss();
    }

}
