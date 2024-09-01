package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.annotations.Steps;
import starter.steps.SearchGoogleStep;

public class SearchDefinitions {
    @Steps
    SearchGoogleStep searchFor;
    @Given("Search by keyword {string}")
    public void searchByKeyword(String keyword){
        searchFor.searchGoogle(keyword);
    }

    @Then("Verify search result {string}")
    public void verifySearchResult(String searchResult) {
        searchFor.verifySearchResult(searchResult);
    }

}
