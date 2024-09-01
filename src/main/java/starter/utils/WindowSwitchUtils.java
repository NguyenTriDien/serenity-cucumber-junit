package starter.utils;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.annotations.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WindowSwitchUtils {

    private static WebDriver getDriver() {
        return Serenity.getDriver();
    }

    @Step("Switch to window or tab by position: {0}")
    public static void switchToWindowOrTabByPosition(int position) {
        List<String> windowHandles = new ArrayList<>(getDriver().getWindowHandles());
        if (position < windowHandles.size()) {
            getDriver().switchTo().window(windowHandles.get(position));
            System.out.println("Switched to window/tab at position: " + position);
        } else {
            throw new IllegalArgumentException("Position out of bounds");
        }
    }

    @Step("Switch back to the original window")
    public static void switchBackToOriginalWindow() {
        String originalWindow = getDriver().getWindowHandles().iterator().next();
        getDriver().switchTo().window(originalWindow);
        System.out.println("Switched back to the original window");
    }

    @Step("Close current window or tab")
    public static void closeCurrentWindowOrTab() {
        getDriver().close();
        System.out.println("Closed current window/tab");
    }

    @Step("Switch to window by title: {0}")
    public static void switchToWindowByTitle(String title) {
        Set<String> windowHandles = getDriver().getWindowHandles();
        for (String windowHandle : windowHandles) {
            getDriver().switchTo().window(windowHandle);
            if (getDriver().getTitle().equals(title)) {
                System.out.println("Switched to window with title: " + title);
                return;
            }
        }
        throw new IllegalArgumentException("No window found with title: " + title);
    }

    @Step("Switch to the latest window or tab")
    public static void switchToLatestWindowOrTab() {
        List<String> windowHandles = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(windowHandles.get(windowHandles.size() - 1));
        System.out.println("Switched to the latest window/tab");
    }
    @Step("Switch to Window or Tab by Url: {0}")
    public static void switchToWindowOrTabByUrl(String url) {
        WebDriver driver = Serenity.getDriver(); // Lấy WebDriver từ Serenity
        String originalWindow = driver.getWindowHandle();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000), Duration.ofMillis(500));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                if (driver.getCurrentUrl().equals(url)) {
                    break;
                }
            }
        }
    }
    // Method to open a new tab
    public static void openNewTabWithJs() {
        WebDriver driver = getDriver();
        ((JavascriptExecutor) driver).executeScript("window.open()");
        switchToNewTab();
    }

    // Method to switch to the newly opened tab
    @Step("Switch to new Tab")
    public static void switchToNewTab() {
        WebDriver driver = getDriver();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
    }
    public static void openNewTabWith() {
        getDriver().switchTo().newWindow(WindowType.WINDOW);
    }
    @Step("Switch to Main Window")
    public static void switchToMainWindow() {
        getDriver().switchTo().window(getDriver().getWindowHandles().toArray()[0].toString());
    }

}
