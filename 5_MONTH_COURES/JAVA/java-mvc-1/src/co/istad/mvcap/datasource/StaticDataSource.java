package co.istad.mvcap.datasource;
import co.istad.mvcap.model.Product;
import java.util.*;
import java.util.UUID;

public class StaticDataSource {
    //done
    private List<Product> productList;
    public StaticDataSource(){
        productList=new ArrayList<>();
        productList.add(new Product(UUID.randomUUID(),1001,"Mouse",20.0));
        productList.add(new Product(UUID.randomUUID(),1002,"Keyword",20.0));
        productList.add(new Product(UUID.randomUUID(),1003,"Laptop",20.0));
        productList.add(new Product(UUID.randomUUID(),1004,"Changer",20.0));
    }

    public List<Product> getProductList() {
        return productList;
    }


    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
