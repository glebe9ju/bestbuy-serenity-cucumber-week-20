package api.bestbuy.cucumber.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ProductsStepsDef {
    @When("^user sends Get request for all produts to endpiont$")
    public void userSendsGetRequestForAllProdutsToEndpiont() {
    }

    @Then("^user must get back valid status code produt$")
    public void userMustGetBackValidStatusCodeProdut() {
    }

    @When("^user sends Post request with products\"([^\"]*)\",\"([^\"]*)\", \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"and\"([^\"]*)\"$")
    public void userSendsPostRequestWithProductsAnd(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^user get back a valid status code$")
    public void userGetBackAValidStatusCode() {
    }

    @When("^User sends a Get request for a newly created product name$")
    public void userSendsAGetRequestForANewlyCreatedProductName() {
    }

    @Then("^User get back with valid status code$")
    public void userGetBackWithValidStatusCode() {
    }

    @When("^User sends a Put request to update a record by product id$")
    public void userSendsAPutRequestToUpdateARecordByProductId() {
    }

    @Then("^User can verify the updated product information$")
    public void userCanVerifyTheUpdatedProductInformation() {
    }

    @When("^User sends a Delete request to delete by product Id and get a status code (\\d+)$")
    public void userSendsADeleteRequestToDeleteByProductIdAndGetAStatusCode(int arg0) {
    }

    @Then("^User get back a valid status code after delte$")
    public void userGetBackAValidStatusCodeAfterDelte() {
    }
}
