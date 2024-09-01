package starter.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.annotations.Steps;
import starter.steps.SearchGoogleStep;
import starter.utils.SessionData;

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

    @Given("Search by keyword")
    public void searchByKeyword(DataTable dataTable) {
        String storeIds = SessionData.tableWithoutHeaderAndSingleRow(dataTable, "store_ids");
        String keyword = SessionData.tableWithoutHeaderAndSingleRow(dataTable, "keyword");
        System.out.println("Search by keyword: " + keyword);
        System.out.println("Search by keyword: " + storeIds);
    }
}
