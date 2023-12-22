package co.istad.mvcap.controller;
import co.istad.mvcap.dao.ProductDaoImp;
import co.istad.mvcap.dto.CreateProductDto;
import co.istad.mvcap.dto.ProductDto;
import co.istad.mvcap.dto.UpdateProductDto;

import java.util.*;

//done
public class ProductController  {
    private final ProductDaoImp productDaoImp;
    public ProductController(){
        this.productDaoImp = new ProductDaoImp();
    }
    public List<ProductDto> handleProductList(){
        return productDaoImp.select();
    }
    public ProductDto handleCreateNewProduct(CreateProductDto createProductDto){
        return productDaoImp.insert(createProductDto);
    }
    public void handleRemoveByID(UUID uuid){
        productDaoImp.removeById(uuid);
    }
    public void handleUpdateById(UUID uuid, UpdateProductDto updateProductDto){
        productDaoImp.updateProductById(uuid,updateProductDto);
    }

}
