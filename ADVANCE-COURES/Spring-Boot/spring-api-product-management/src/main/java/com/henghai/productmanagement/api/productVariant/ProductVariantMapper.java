package com.henghai.productmanagement.api.productVariant;

import com.henghai.productmanagement.api.product.Product;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Mapper
@Repository
public interface ProductVariantMapper {
    @SelectProvider(type = ProductVariantProvider.class,method ="SelectProductVariantSql" )
    @Results(id = "productResultMap",value = {
              @Result(column = "product_id",property = "productId"),
            @Result(column = "product_id", property = "product", one = @One(select = "selectProductId"))

    })
    List<ProductVariant> selectProductVariant(@Param("color")String color);

    @Select("SELECT * FROM product WHERE id = #{product_id}")
    Optional<Product> selectProductId(Integer product_id);



    @InsertProvider(type = ProductVariantProvider.class,method = "InsertProductVariantBuildSql")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
//    @ResultMap("productResultMap")
    void createProductVariant(@Param("p") ProductVariant productVariant);

    @SelectProvider(type = ProductVariantProvider.class,method = "buildSelectVariantByIdSql")

    Optional<ProductVariant> selectById(@Param("id") Integer id);

    @Select("""
            SELECT EXISTS(SELECT *
            FROM product_variant
            WHERE id = #{id})
            """)
    boolean existsById(@Param("id") Integer id);

    @UpdateProvider(type = ProductVariantProvider.class, method = "buildUpdateVariantSql")
    void update(@Param("u") ProductVariant productVariant);

    @Delete("""
            DELETE FROM product_variant
            WHERE id = #{id}
            """)
    void deleteById(@Param("id")Integer id);






}
