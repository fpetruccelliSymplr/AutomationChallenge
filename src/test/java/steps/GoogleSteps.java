package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.GooglePage;

public class GoogleSteps {

    GooglePage google = new GooglePage();

    @Given("the user is on Google main page")
    public void theUserIsOnGoogleMainPage() {
        google.navigateToGoogle();
    }

    @When("^the user search for (.+)$")
    public void theUserSearchForAWord(String word) {
        google.enterSearchCriteria(word);
        google.clickSearchButton();
    }

    @Then("^the (.+) match the search criteria$")
    public void theResultsMatchTheSearchCriteria(String result) {
        Assert.assertEquals( result, google.getGoogleFirstResult());
    }
}
