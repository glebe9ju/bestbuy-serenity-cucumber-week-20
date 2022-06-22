package api.bestbuy.bestbuyinfo;

import api.bestbuy.constants.EndPoints;
import api.bestbuy.constants.Path;
import api.bestbuy.model.CategoriesPojo;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.util.HashMap;

public class CategoriesSteps {
    public CategoriesSteps() {
        RestAssured.basePath = Path.CATEGORIES;
    }

    @Step("Getting all Categories information")
    public ValidatableResponse getAllCategories() {
        return SerenityRest.given()
                .when().get()
                .then();
    }

    @Step("Creating Category with categoryId: {0}, name: {1}")
    public ValidatableResponse createCategory(String categoryId, String name) {
        CategoriesPojo categoriesPojo = CategoriesPojo.getCategoriesPojo(categoryId, name);
        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .body(categoriesPojo)
                .when()
                .post()
                .then();
    }

    @Step("Getting the Category informationwith categoryId: {0}, name{1}")
    public HashMap<String, Object> getCategoryInfoById(String categoryId, String name) {
        String p1 = "data.findAll{it.name=='";
        String p2 = "'}.get(0)";
        return SerenityRest.given().log().all()
                .queryParam("id", categoryId)
                .when()
                .get()
                .then()
                .statusCode(200)
                .extract()
                .path(p1 + name + p2);
    }

    @Step("Updating Category information with categoryId: {0}, name:{1}")
    public ValidatableResponse updateCategory(String categoryId, String name) {
        CategoriesPojo categoriesPojo = CategoriesPojo.getCategoriesPojo(categoryId, name);
        return SerenityRest.given().log().all()
                .header("Content-Type", "application/json")
                .pathParam("categoryId", categoryId)
                .body(categoriesPojo)
                .when()
                .put(EndPoints.UPDATE_CATEGORIES_BY_ID)
                .then();
    }

    @Step("Deleting Category information with categoryId: {0}")
    public ValidatableResponse deleteCategory(String categoryId) {
        return SerenityRest.given()
                .pathParam("categoryId", categoryId)
                .when()
                .delete(EndPoints.DELETE_CATEGORIES_BY_ID)
                .then();
    }
    @Step("Getting Category information with categoryId: {0}, name{1}")
    public ValidatableResponse getCategoryById(String categoryId){
        return SerenityRest.given()
                .pathParam("categoryId", categoryId)
                .when()
                .get(EndPoints.GET_SINGLE_CATEGORIES_BY_ID)
                .then();
    }
}

