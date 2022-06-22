package api.bestbuy.testbase;

import api.bestbuy.utils.PropertyReader;
import io.restassured.RestAssured;
import org.junit.BeforeClass;

/**
 * Created by Jay
 */
public class TestBase {
    public static PropertyReader propertyReader;

    @BeforeClass
    public static void init() {
        propertyReader = PropertyReader.getInstance();
        RestAssured.baseURI = propertyReader.getProperty("baseUrl");
        RestAssured.port = Integer.parseInt(propertyReader.getProperty("port"));
//        RestAssured.basePath = Path.PRODUCTS;    //products
//        RestAssured.basePath = Path.STORES;    //products
//        RestAssured.basePath = Path.CATEGORIES;    //products
//        RestAssured.basePath = Path.SERVICES;    //products
    }

}
