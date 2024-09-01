package starter.utils;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Keys;
import java.time.Duration;

import static net.serenitybdd.core.Serenity.getDriver;

public class ActionsUtils{
    private static Actions actions = new Actions(getDriver());

    // Nhấn vào phần tử hiện tại
    public static void click(WebElementFacade element) {
        actions.click(element).perform();
    }

    // Nhấp chuột phải vào phần tử hiện tại
    public static void contextClick(WebElementFacade element) {
        actions.contextClick(element).perform();
    }

    // Nhấp đúp vào phần tử hiện tại
    public static void doubleClick(WebElementFacade element) {
        actions.doubleClick(element).perform();
    }

    // Kéo thả phần tử từ source đến target
    public static void dragAndDrop(WebElementFacade source, WebElementFacade target) {
        actions.dragAndDrop(source, target).perform();
    }

    // Kéo thả phần tử từ source đến một vị trí offset
    public static void dragAndDropBy(WebElementFacade source, int xOffset, int yOffset) {
        actions.dragAndDropBy(source, xOffset, yOffset).perform();
    }

    // Di chuyển chuột đến phần tử
    public static void moveToElement(WebElementFacade element) {
        actions.moveToElement(element).perform();
    }

    // Di chuyển chuột đến phần tử và thay đổi vị trí thêm xOffset và yOffset
    public static void moveToElement(WebElementFacade element, int xOffset, int yOffset) {
        actions.moveToElement(element, xOffset, yOffset).perform();
    }

    // Gửi các phím đến phần tử
    public static void sendKeys(WebElementFacade element, CharSequence... keysToSend) {
        actions.sendKeys(element, keysToSend).perform();
    }

    // Nhấn giữ một phím
    public static void keyDown(Keys key) {
        actions.keyDown(key).perform();
    }

    // Thả một phím
    public static void keyUp(Keys key) {
        actions.keyUp(key).perform();
    }

    // Tạm dừng các hành động trong một khoảng thời gian
    public static void pause(Duration duration) {
        actions.pause(duration).perform();
    }

    // Thả chuột từ phần tử hiện tại
    public static void release() {
        actions.release().perform();
    }

    // Thả chuột từ phần tử web cụ thể
    public static void release(WebElementFacade element) {
        actions.release(element).perform();
    }

    // Ví dụ về việc thực hiện một chuỗi hành động
    public static void performComplexAction(WebElementFacade source, WebElementFacade target, WebElementFacade hoverElement, CharSequence... keysToSend) {
        actions.dragAndDrop(source, target)
                .moveToElement(hoverElement)
                .sendKeys(keysToSend)
                .perform();
    }
    public static void scrollToElement(WebElementFacade element) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public static void sendEnterKey() {
        Actions actions = new Actions(getDriver());
        actions.sendKeys(Keys.ENTER).perform();
    }
}


