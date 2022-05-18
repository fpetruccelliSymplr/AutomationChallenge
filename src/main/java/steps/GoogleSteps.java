package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.GooglePage;

public class GoogleSteps {

    GooglePage google = new GooglePage();

    @Given("the user is on Google main page")
    public void theUserIsOnGoogleMainPage() {
        google.navigateToGoogle();
    }

    @When("the user search for a word")
    public void theUserSearchForAWord() {
        
    }

    @Then("the results match the search criteria")
    public void theResultsMatchTheSearchCriteria() {
    }
}
