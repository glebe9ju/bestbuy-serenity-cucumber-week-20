package api.bestbuy.cucumber.steps;

import api.bestbuy.bestbuyinfo.ServicesSteps;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;

public class ServiceStepsDef {

    static ValidatableResponse response;
    static String name = "Home Services";
    static int serviceId;
    @Steps
    ServicesSteps servicesSteps;

    @When("^User sends a Get request for all services to list endpoint$")
    public void userSendsAGetRequestForAllServicesToListEndpoint() {
        servicesSteps.getAllService().log().all();
        response = servicesSteps.getAllService().log().all();
        System.out.println(response.log().all());
    }

    @Then("^User must get back a valid status code 200")
    public void userMustGetBackAValidStatusCode200() {
        response.statusCode(200);
    }

    @When("^User sends a Post request with service name$")
    public void userSendsAPostRequestWithServiceName() {
        response=servicesSteps.createdService(name).log().all();
        System.out.println(response.log().all());
    }
    @Then("^User must get back a valid status code 201")
    public void userMustGetBackAValidStatusCode201() {
        response.statusCode(201);
    }

    @When("^User sends a Get request for a newly created service name$")
    public void userSendsAGetRequestForANewlyCreatedServiceName() {
        HashMap<String, Object> value = servicesSteps.getServiceInfoByName(name);
        Assert.assertThat(value,hasValue(name));
        serviceId = (int) value.get("id");
        System.out.println(serviceId);

    }
    @Then("^User must get back a valid status code 200$")
    public void userMustGetBackAValidStatusCode() {
        servicesSteps.getServiceById(serviceId).log().all().statusCode(200);
    }

    @When("^User sends a Put request to update a record by service ID$")
    public void userSendsAPutRequestToUpdateARecordByServiceID() {
        name = name + "_updated";
        servicesSteps.updateService(serviceId,name).log().all().statusCode(200);
    }

    @Then("^User can verify the updated information$")
    public void userCanVerifyTheUpdatedInformation() {
        HashMap<String, Object>value = servicesSteps.getServiceInfoByName(name);
        Assert.assertThat(value,hasValue(name));
        serviceId = (int) value.get("id");
        System.out.println(serviceId + "and" + name);

    }

    @When("^User sends Delete request to delet by services id and get a status code (\\d+)$")
    public void userSendsDeleteRequestToDeletByServicesIdAndGetAStatusCode() {
        servicesSteps.deleteService(serviceId).log().all().statusCode(200);

    }


    @Then("^User must get back a valid status code (\\d+)$")
    public void userMustGetBackAValidStatusCode404() {
        servicesSteps.getServiceById(serviceId).log().all().statusCode(404);
    }
}
