package api.bestbuy.model;

public class CategoriesPojo {

    private String id;
    private String name;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public static CategoriesPojo getCategoriesPojo(String id, String name){
        CategoriesPojo categoriesPojo = new CategoriesPojo();
        categoriesPojo.setId(id);
        categoriesPojo.setName(name);
        return categoriesPojo;
                    }
}
