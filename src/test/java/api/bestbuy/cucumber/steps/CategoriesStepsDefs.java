package api.bestbuy.cucumber.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CategoriesStepsDefs {
    @When("^User sends a Get request for all categories to endpoint$")
    public void userSendsAGetRequestForAllCategoriesToEndpoint() {
    }

    @Then("^User get back a valid status code (\\d+)$")
    public void userGetBackAValidStatusCode(int arg0) {
    }

    @When("^User sends a Post request with category and ID name$")
    public void userSendsAPostRequestWithCategoryAndIDName() {
    }

    @When("^User sends a Get request for a newly created Ctegory name$")
    public void userSendsAGetRequestForANewlyCreatedCtegoryName() {
    }

    @Then("^User get back with valid status code (\\d+)$")
    public void userGetBackWithValidStatusCode(int arg0) {
    }

    @When("^User sends a Put request to update a record by category Id$")
    public void userSendsAPutRequestToUpdateARecordByCategoryId() {
    }

    @Then("^User can verify the updated categoty information$")
    public void userCanVerifyTheUpdatedCategotyInformation() {
    }

    @When("^User sends a Delete request to delete by category Id and get a status code (\\d+)$")
    public void userSendsADeleteRequestToDeleteByCategoryIdAndGetAStatusCode(int arg0) {
    }
}
