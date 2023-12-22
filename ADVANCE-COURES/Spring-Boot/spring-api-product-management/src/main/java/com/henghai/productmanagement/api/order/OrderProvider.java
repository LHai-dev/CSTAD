package com.henghai.productmanagement.api.order;

import org.apache.ibatis.jdbc.SQL;

public class OrderProvider {
    public String buildSelectOrderSql(){
        return new SQL(){{
            SELECT("*");
            FROM("orders");
        }}.toString();
    }



    public String buildInsertOrderSql(){
        return new SQL(){{
                INSERT_INTO("orders");
            VALUES("order_date","#{p.orderDate}");
            VALUES("user_id","#{p.userId}");
        }}.toString();
    }
}
