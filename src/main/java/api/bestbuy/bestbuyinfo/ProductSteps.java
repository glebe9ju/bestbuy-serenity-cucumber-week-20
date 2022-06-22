package api.bestbuy.bestbuyinfo;

import api.bestbuy.constants.EndPoints;
import api.bestbuy.constants.Path;
import api.bestbuy.model.ProductsPojo;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.util.HashMap;

public class ProductSteps {
    public ProductSteps(){
        RestAssured.basePath= Path.PRODUCTS;}

    @Step("Getting all product information")
    public ValidatableResponse getAllProduct(){
        return SerenityRest.given()
                .when()
                .get()
                .then();
                    }
    @Step("Creating products with name: {0},type: {1}, price: {2}, upc: {3}, shipping: {4}, description: {5}, manufacturer: {6}, model: {7}, url: {8}, image: {9}")
    public ValidatableResponse createProduct(String name, String type, double price, String upc, int shipping, String description,
                                             String manufacturer, String model, String url, String image) {
        ProductsPojo productsPojo = ProductsPojo.getProductsPojo(name,type,price,upc,shipping,description,manufacturer,model,url,image);

        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .body(productsPojo)
                .when()
                .post()
                .then();
    }

    @Step("Getting the product information with name: {0}")
    public HashMap<String, Object> getProductInfoByName(String name, String type, String manufacturer) {
        String p1 = "findAll{it.name=='";
        String p2 = " '}.get(0)";
return SerenityRest.given().log().all()
        .queryParam("type",type)
        .queryParam("manufacturer",manufacturer)
                .when()
                .get()
                .then()
                .statusCode(200)
                .extract()
                .path(p1 + name + p2);
    }

    @Step("Updating product information with productId: {0}, name: {1}, type: {2}, price: {3}, upc:{4}, " +
            "shipping: {5}, description: {6}, manufacturer: {7}, model: {8}, url: {9}, image: {10}")
    public ValidatableResponse updateProduct(int productId, String name, String type, double price,
                                             String upc, int shipping, String description, String manufacturer, String model, String url,String image) {
        ProductsPojo productsPojo = ProductsPojo.getProductsPojo(name, type, price, upc, shipping, description, manufacturer, model, url, image);
        {

            return SerenityRest.given().log().all()
                    .header("Content-Type", "application/jdon")
                    .pathParam("productID", productId)
                    .body(productsPojo)
                    .when()
                    .put(EndPoints.UPDATE_PRODUCTS_BY_ID)
                    .then();
        }
    }
    @Step("Deleting product information with productId: {0}")
    public ValidatableResponse deleteProduct(int productId) {
        return SerenityRest.given().log().all()
                .pathParam("productId", productId)
                .when()
                .delete(EndPoints.DELETE_PRODUCTS_BY_ID)
                .then();
    }

    @Step("Getting product information with productId: {0}")
    public ValidatableResponse getProductById(int productId){
        return SerenityRest.given()
                .pathParam("productId",productId)
                .when()
                .get(EndPoints.GET_SINGLE_PRODUCTS_BY_ID)
                .then();


    }

    }

