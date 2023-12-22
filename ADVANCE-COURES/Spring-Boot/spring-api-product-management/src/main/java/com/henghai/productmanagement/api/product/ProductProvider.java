package com.henghai.productmanagement.api.product;

import org.apache.ibatis.jdbc.SQL;

public class ProductProvider {
    public String buildSelectProductSql(){
        return new SQL(){{
            SELECT("*");
            FROM("product");
            WHERE("name ILIKE '%' || #{name} || '%'");
            ORDER_BY("id DESC");
        }}.toString();
    }
    public String buildSelectProductByColorAndCategorySql(){
        return new SQL(){{
            SELECT("*");
            FROM("product");
            WHERE("(name ILIKE '%' || #{name} || '%') AND (category_id = #{cId})");
            ORDER_BY("id DESC");
        }}.toString();
    }
    public String buildInsertProductSql(){
        return new SQL(){{
            INSERT_INTO("product");
            VALUES("name","#{p.name}");
            VALUES("category_id","#{p.categoryId}");
        }}.toString();
    }


    public String buildSelectGetById(){
        return new SQL(){{
            SELECT("*");
            FROM("product");
            WHERE("id=#{id}");
        }}.toString();

    }

    public String buildUpdateProductByIdSql(){
        return new SQL(){{
            UPDATE("product");
            SET("name = #{u.name}");
            SET("category_id = #{u.categoryId}");
            WHERE("id=#{u.id}");
        }}.toString();
    }
}
