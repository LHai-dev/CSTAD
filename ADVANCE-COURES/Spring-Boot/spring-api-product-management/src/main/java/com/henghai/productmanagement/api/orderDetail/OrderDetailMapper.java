package com.henghai.productmanagement.api.orderDetail;

import com.henghai.productmanagement.api.order.Order;
import com.henghai.productmanagement.api.product.Product;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Type;
import java.util.List;

@Repository
@Mapper
public interface OrderDetailMapper {
    @SelectProvider(type = OrderDetailProvider.class,method = "buildSelectOrderDetailSql")
    @Results(id = "reId" , value = {
            @Result(column = "product_id",property = "product",one = @One(select = "selectProducts")),
            @Result(column = "order_id",property = "order",one = @One(select = "selectOrder"))

    })
    List<OrderDetail> selectAll();

    @Select("SELECT * FROM product WHERE id = #{productId}")
    List<Product> selectProducts(@Param("productId") Integer productId);

    @Select("SELECT * FROM orders WHERE id = #{orderId}")
    @Result(column = "order_date",property = "orderDate")
    List<Order> selectOrder(@Param("orderId") Integer orderId);
}