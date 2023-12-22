package com.henghai.productmanagement.api.order;

import com.henghai.productmanagement.api.order.web.CreateOrderDto;
import com.henghai.productmanagement.api.orderDetail.OrderDetail;
import com.henghai.productmanagement.api.orderDetail.OrderDetailProvider;
import com.henghai.productmanagement.api.product.ProductProvider;
import com.henghai.productmanagement.api.product.web.ProductDto;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface OrderMapper {
    @SelectProvider(type = OrderProvider.class,method = "buildSelectOrderSql")
    @Results(id = "reId1" , value = {
            @Result(column = "id",property = "id"),
            @Result(column = "order_date",property = "orderDate"),
            @Result(column = "user_id",property = "userId")
    })
    List<Order> selectAll();
//    -=-=-=-=-=-=-=-=
@InsertProvider(type = OrderProvider.class, method = "buildInsertOrderSql")
@Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
@ResultMap("reId1")
int insertOrder(@Param("p") CreateOrderDto createOrderDto);
}
