package starter.steps;

import net.serenitybdd.annotations.Step;
import starter.page.Search;
import starter.utils.ActionsUtils;
import starter.utils.WaitUtils;

public class SearchGoogleStep {
     Search search;

    @Step
    public void searchGoogle(String keywords){
        search.search(keywords);
        ActionsUtils.sendEnterKey();
    }
    @Step
    public void verifySearchResult(String keywords) {
        search.verifySearch(keywords);
    }
    @Step
    public void openBrowser(){
        search.open();
        WaitUtils.waitForJavaScriptToLoad();
    }
}
