package com.henghai.productmanagement.api.orderDetail;

import org.apache.ibatis.jdbc.SQL;

public class OrderDetailProvider {
    public String buildSelectOrderDetailSql(){
        return new SQL(){{
                SELECT("*");
                FROM("order_detail");
            }}.toString();
    }
}
