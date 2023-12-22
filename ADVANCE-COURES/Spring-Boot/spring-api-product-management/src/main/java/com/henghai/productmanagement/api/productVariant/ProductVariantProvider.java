package com.henghai.productmanagement.api.productVariant;

import com.henghai.productmanagement.api.product.Product;
import org.apache.ibatis.jdbc.SQL;


public class ProductVariantProvider {
    private final String TABLE = "product_variant";

   public String SelectProductVariantSql(){
       return new SQL(){{
            SELECT("*");
            FROM(TABLE);
           WHERE("color ILIKE '%' || #{color} || '%'");
           ORDER_BY("id DESC");
       }}.toString();
   }

   public String InsertProductVariantBuildSql(){
       return new SQL(){{
           INSERT_INTO(TABLE);
           VALUES("description","#{p.description}");
           VALUES("price","#{p.price}");
           VALUES("size","#{p.size}");
           VALUES("color","#{p.color}");
           VALUES("stock","#{p.stock}");
           VALUES("product_id","#{p.productId}");
       }}.toString();
   }
    //
   public String buildSelectVariantByIdSql(){
       return new SQL(){{
           SELECT("*");
           FROM(TABLE);
           WHERE("id=#{id}");
       }}.toString();
   }

    public String buildUpdateVariantSql() {
        return new SQL() {{
            UPDATE(TABLE);
            SET("description = #{u.description}");
            SET("price = #{u.price}");
            SET("size = #{u.size}");
            SET("color = #{u.color}");
            SET("product_id = #{u.productId}");
            WHERE("id = #{u.id}");
        }}.toString();
    }
    //

    public String buildSelectProduct1(){
       return new SQL(){{
           SELECT("*");
           FROM("product");
           WHERE("id=#{id}");
       }}.toString();
    }
    public String productSqlProvider(Product product){
       return new SQL(){{
    INSERT_INTO("products");
    VALUES(" id"," #{id}");

       }}.toString();
    }
}
