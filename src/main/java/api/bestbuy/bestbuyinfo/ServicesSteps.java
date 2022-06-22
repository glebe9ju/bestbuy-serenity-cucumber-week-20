package api.bestbuy.bestbuyinfo;

import api.bestbuy.constants.EndPoints;
import api.bestbuy.constants.Path;
import api.bestbuy.model.ServicesPojo;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

import java.util.HashMap;

public class ServicesSteps {
    public ServicesSteps() {
        RestAssured.basePath = Path.SERVICES;
    }

    @Step("Creating all services information")
    public ValidatableResponse getAllService() {
        return SerenityRest.given()
                .when()
                .get()
                .then();
    }

    @Step("Creating Services with name: {0}")
    public ValidatableResponse createdService(String name) {
        ServicesPojo servicesPojo = ServicesPojo.getServicePojo(name);
        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .body(servicesPojo)
                .when()
                .post()
                .then();
    }

    @Step("Getting the product information with name: {0}")
    public HashMap<String, Object> getServiceInfoByName(String name){
        String p1 = "data.findAll{it.name=='";
        String p2 = " ' }.get(0)";
        return SerenityRest.given().log().all()
                .queryParam("$limit", 40)
                .queryParam("name", name)
                .when()
                .get()
                .then()
                .statusCode(200)
                .extract()
                .path(p1 + name + p2);

    }
    @Step("Updating service information with serviceId: {0}, name: {1}")
    public ValidatableResponse updateService(int serviceId, String name) {
        ServicesPojo servicesPojo = ServicesPojo.getServicePojo(name);
        return SerenityRest.given().log().all()
                .header("Content-Type", "application/json")
                .pathParam("serviceId", serviceId)
                .body(servicesPojo)
                .when()
                .put(EndPoints.UPDATE_SERVICES_BY_ID)
                .then();

    }

    @Step("Deleting service information with serviceId: {0}")
    public ValidatableResponse deleteService(int serviceId) {
        return SerenityRest.given()
                .pathParam("serviceId", serviceId)
                .when()
                .delete(EndPoints.DELETE_SERVICES_BY_ID)
                .then();
    }

    @Step("Getting service information with serviceId: {0}")
    public ValidatableResponse getServiceById(int serviceId) {
        return SerenityRest.given().log().all()
                .pathParam("serviceId", serviceId)
                .when()
                .get(EndPoints.GET_SINGLE_SERVICES_BY_ID)
                .then();
    }


}
