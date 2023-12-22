package com.henghai.productmanagement.api.product;

import com.henghai.productmanagement.api.category.Categories;
import com.henghai.productmanagement.api.image.Images;

import com.henghai.productmanagement.api.productVariant.ProductVariant;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Mapper
public interface ProductMapper {


    // Product has a relationship with ProductVariant
    @SelectProvider(type = ProductProvider.class, method = "buildSelectProductSql")
    @Results(id = "mapRes", value = {
            @Result(column = "id", property = "id"),
            @Result(column = "category_id", property = "categoryId"),
            @Result(column = "category_id", property = "categories", one = @One(select = "selectCategories")),
            @Result(column = "id", property = "productVariants", many = @Many(select = "selectProductVariant")),
            @Result(column = "id", property = "image", many = @Many(select = "selectProductImages"))
    })
    List<Product> findAll(@Param("name")String name);


    @SelectProvider(type = ProductProvider.class, method = "buildSelectProductByColorAndCategorySql")
    @ResultMap("mapRes")
    List<Product> findAllByColor(@Param("name")String name,@Param("cId") Integer categoryId);

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
    @Select("select * from categories where id = #{categoriesID}")
    List<Categories> selectCategories(@Param("categoriesID") Integer categoriesID);


    @Select("SELECT * FROM images WHERE product_id = #{id}")
    @Result(column = "image_url",property = "imageUrl")
    List<Images> selectProductImages(@Param("id") Integer id);

//    @Select("SELECT * FROM images where id = #{id}")
//    @Result(column = "image_url",property = "imageUrl")
//    List<Images> selectAllImage(@Param("id") Integer id);

    @Select("SELECT * FROM product_variant WHERE product_id = #{productId}")
    ProductVariant selectProductVariant(@Param("productId") Integer productId);
    //    =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==

    //   -=-=-=-=----=-=-=-==-=-=-- add product
    @InsertProvider(type = ProductProvider.class, method = "buildInsertProductSql")
    @ResultMap("mapRes")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void insertProductForAdminDto(@Param("p") Product product);
    //   -=-=-=-=----=-=-=-==-=-=-- add product
    @SelectProvider(type = ProductProvider.class, method = "buildSelectGetById")
    @ResultMap("mapRes")
    Optional<Product> getProductById(@Param("id") Integer id);

    @Select("""
            SELECT EXISTS(SELECT *
            FROM product
            WHERE id = #{id})
            """)
    boolean existsProductById(@Param("id") Integer id);

    //    DELETE FROM table_name WHERE condition;
    @Select("SELECT COUNT(*) FROM product_variant WHERE product_id = #{id}")
    int countReferencesInProductVariant(@Param("id") Integer id);
    @Select("SELECT COUNT(*) FROM order_detail WHERE product_id = #{id}")
    int countReferencesInOrderDetail(@Param("id") Integer id);
    //-=-=-=-=-=-=-=-===-=-delete-=--=-=-=-=-=-=-=--=-=-=-
    @Delete("DELETE FROM order_detail WHERE product_id = #{id}")
    Boolean deleteProductIdOrderDetailById(@Param("id") Integer id);

    @Delete("DELETE FROM product_variant WHERE product_id = #{productId}")
    void deleteProductVariantsByProductId(@Param("productId") Integer productId);

    @Delete("DELETE FROM product WHERE id = #{id}")
    int deleteProductById(@Param("id") Integer id);
    //-=-=-=-=-=-=-=-===-=-delete-=--=-=-=-=-=-=-=--=-=-=-

    //        -=-=-=-=-=-=-=-=-=-=-=-=-=-=
    @Update("UPDATE products SET stock = stock - 1 WHERE id = #{id}")
    void updateStock(@Param("productId") Integer id);

    @Select("SELECT stock FROM products WHERE id = #{id}")
    int getStockCount(@Param("productId") Integer id);
    //    -=--=-=-=-=-=-=-=-=-=-=-=-=-=


//    -=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=Update By id-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
    @UpdateProvider(type = ProductProvider.class,method = "buildUpdateProductByIdSql")
    void updateProductById(@Param("u")Product product);
}
