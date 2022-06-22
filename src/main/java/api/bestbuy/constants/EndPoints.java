package api.bestbuy.constants;

/**
 * Created by Naresh Savalia
 */
public class EndPoints {

    /**
     * This is Endpoints of bestbuy Products api
     */
    public static final String GET_ALL_PRODUCTS = "/list";
    public static final String GET_SINGLE_PRODUCTS_BY_ID = "/{productId}";
    public static final String UPDATE_PRODUCTS_BY_ID = "/{productId}";
    public static final String DELETE_PRODUCTS_BY_ID = "/{productId}";
    /**
     * This is Endpoints of bestbuy CATEGORIES api
     */
    public static final String GET_ALL_CATEGORIES = "/list";
    public static final String GET_SINGLE_CATEGORIES_BY_ID = "/{categoryId}";
    public static final String UPDATE_CATEGORIES_BY_ID = "/{categoryId}";
    public static final String DELETE_CATEGORIES_BY_ID = "/{categoryId}";
    /**
     * This is Endpoints of bestbuy STORES api
     */
    public static final String GET_ALL_STORES="";
    public static final String GET_SINGLE_STORES_BY_ID = "/{storeId}";
    public static final String UPDATE_STORES_BY_ID = "/{storeId}";
    public static final String DELETE_STORES_BY_ID = "/{storeId}";
    /**
     * This is Endpoints of bestbuy SERVICES api
     */
    public static final String GET_ALL_SERVICES = "/list";
    public static final String GET_SINGLE_SERVICES_BY_ID = "/{serviceId}";
    public static final String UPDATE_SERVICES_BY_ID = "/{serviceId}";
    public static final String DELETE_SERVICES_BY_ID = "/{serviceId}";


}
