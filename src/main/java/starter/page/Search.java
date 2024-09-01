package starter.page;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.testng.Assert;
import starter.utils.ActionsUtils;
import starter.utils.LocatorUtils;
import starter.utils.WaitUtils;

import java.time.Duration;

@DefaultUrl("page:home.page")
public class Search extends PageObject {
      public void search(String search) {
          find(By.xpath(LocatorUtils.getXPathForAttribute("type","search","*"))).waitUntilEnabled().sendKeys(search);
    }
    public void verifySearch(String search) {
        WebElementFacade elementFacebook = find(By.xpath(LocatorUtils.getXPathForText(search,"span")));
        elementFacebook.waitUntilPresent();
        WaitUtils.waitForElementText(search, elementFacebook);
        Assert.assertEquals(elementFacebook.getText(), search);
    }
}
