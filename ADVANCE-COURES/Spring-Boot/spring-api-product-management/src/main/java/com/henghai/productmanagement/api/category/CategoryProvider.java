package com.henghai.productmanagement.api.category;

import org.apache.ibatis.jdbc.SQL;

public class CategoryProvider {
    private final String TABLE = "categories";
    public String buildSelectSql(){
        return new SQL(){{
            SELECT("*");
            FROM(TABLE);
        }}.toString();
    }


}
