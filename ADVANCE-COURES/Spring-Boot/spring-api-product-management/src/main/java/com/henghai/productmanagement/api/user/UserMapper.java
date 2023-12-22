package com.henghai.productmanagement.api.user;

import com.henghai.productmanagement.api.order.Order;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Mapper
public interface UserMapper {
    @SelectProvider(type = UserProvider.class,method = "buildSelectUserSql")
    @Results(id = "userId" ,value = {
            @Result(property = "id",column = "id"),
            @Result(property = "name",column = "user_name"),
            @Result(property = "phoneNumber",column = "phone_number"),
            @Result(property = "isVerified",column = "is_verified"),
            @Result(property = "order",column = "id",many = @Many(select = "selectOrder"))
    })
    List<User> selectAll();

    @Select(value = "SELECT * FROM orders WHERE user_id = #{orderId}")

    @Result(property = "orderDate",column = "order_date")
    @Result(property = "userId",column = "user_id")
    List<Order> selectOrder(@Param("orderId") Integer orderId);

    @InsertProvider(type = UserProvider.class,method = "buildInsertUserSql")
    @ResultMap("userId")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void insert(@Param("u") User user);

    @Select("""
            SELECT EXISTS(SELECT * FROM users WHERE id = #{id})
            """)
    boolean existsUser(@Param("id")Integer id);
    @DeleteProvider(type = UserProvider.class,method = "buildDeleteByIdSql")
    int deleteById(@Param("id")Integer id);

    @SelectProvider(type = UserProvider.class,method = "buildSelectById")
    @ResultMap("userId")
    Optional<User> getUserById(@Param("id")Integer id);

    @UpdateProvider(type = UserProvider.class,method = "buildUpdateUserSql")
    @ResultMap("userId")
    void updateUserBuId(@Param("user")User user);
}
