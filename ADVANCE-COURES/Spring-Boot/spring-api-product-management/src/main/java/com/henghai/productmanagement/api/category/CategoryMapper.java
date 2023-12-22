package com.henghai.productmanagement.api.category;


import com.henghai.productmanagement.api.product.Product;
import com.henghai.productmanagement.api.productVariant.ProductVariant;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Mapper
@Repository
public interface CategoryMapper {



    @SelectProvider(type = CategoryProvider.class, method = "buildSelectSql")
    @Results(id = "mapId", value = {
            @Result(column = "id", property = "id"),
            @Result(column = "name",property = "name"),
//            @Result(column = "id", property = "product", many = @Many(select = "selectProducts"))
    })
    List<Categories> selectAll();

    @Select("SELECT id,name,image FROM product where id = #{productId}")
    Optional<Product> selectProducts(@Param("productId") Integer productId);


}
