package api.bestbuy.cucumber.steps;

import api.bestbuy.bestbuyinfo.StoreSteps;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;

public class StoreStepsDef {

    static String name = "South East England";
    static String type = "SuperPower";
    static String address = "205 Watford Street";
    static String address2 = "Main Street";
    static String city = "Manchester";
    static String state = "Manchester";
    static String zip = "51112";
    static double lat = 45.0365556;
    static double lng = 93.0259986;
    static String hours = "Mon: 10-9,Tue: 10-9,Wed: 10-9,Thurs: 10-9, Fri: 10-9, Sat: 10-9, Sun: 10-4";
    static int storeId;

    @Steps
    StoreSteps storeSteps;

    @When("^User sends a Get request for all stores to endpoint and status code (\\d+)$")
    public void userSendsAGetRequestForAllStoresToEndpointAndStatusCode() {
        storeSteps.getAllStore().log().all().statusCode(200);
    }

    @When("^User sends a Post request with stores \"([^\"]*)\", \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" and \"([^\"]*)\"$")
    public void userSendsAPostRequestWithStoresAnd(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9) {
        storeSteps.createStore(name,type,address,address2,city,state,zip,lat,lng,hours).log().all().statusCode(201);
            }

    @When("^User sends a Get request for a newly created stores name and get valid status code$")
    public void userSendsAGetRequestForANewlyCreatedStoresNameAndGetValidStatusCode() {
        HashMap<String,Object> value=storeSteps.getStoreInfoByName(name,type,city);
        Assert.assertThat(value,hasValue(name));
        storeId=(int) value.get("id");
        System.out.println(storeId);
    }

    @When("^User sends a Put request to update a record by stores Id$")
    public void userSendsAPutRequestToUpdateARecordByStoresId() {
        name = name + "_updated";
        storeSteps.updateStore(storeId,name,type,address,address2,city,state,zip,lat,lng,hours).log().all().statusCode(200);

    }

    @Then("^User can verify the updated stores information$")
    public void userCanVerifyTheUpdatedStoresInformation() {
        HashMap<String,Object> value = storeSteps.getStoreInfoByName(name,type,city);
        Assert.assertThat(value,hasValue(name));
        storeId=(int) value.get("id");
        System.out.println("id:" + storeId + "Store: " + name);
    }

    @When("^User sends a Delete request to delete by stores Id and get a status code (\\d+)$")
    public void userSendsADeleteRequestToDeleteByStoresIdAndGetAStatusCode() {
        storeSteps.deleteStore(storeId).log().all().statusCode(200);

    }

    @Then("^User get back a valid status code after delete stores$")
    public void userGetBackAValidStatusCodeAfterDeleteStores() {
        storeSteps.getStoreById(storeId).log().all().statusCode(404);
    }
}
