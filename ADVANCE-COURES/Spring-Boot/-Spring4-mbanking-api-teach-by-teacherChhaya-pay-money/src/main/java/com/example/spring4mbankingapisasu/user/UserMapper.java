package com.example.spring4mbankingapisasu.user;

import io.swagger.v3.oas.models.security.SecurityScheme;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Mapper
@Repository
public interface UserMapper {

    /**
     * InsertUser
     *
     * @param user
     */
    @InsertProvider(type = UserProvider.class, method = "buildInsertUserSql")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void insert(@Param("u") User user);

    @SelectProvider(type = UserProvider.class, method = "buildSelectByIdSql")
    @Results(id = "userResultMap", value = {
            @Result(column = "is_student", property = "isStudent"),
            @Result(column = "student_card_id", property = "studentCard")
    })
    Optional<User> selectById(@Param("id") Integer id);

    @Select("""
            SELECT EXISTS(
                SELECT *
                FROM users
                WHERE id = #{id}
            )
            """)
    boolean existsById(@Param("id") Integer id);


    @UpdateProvider(type = UserProvider.class, method = "buildUpdateSql")
    void update(@Param("u") User user);


    @Select("SELECT EXISTS(SELECT * FROM users WHERE email=#{email})")
    boolean existByEmail(String email);


    @SelectProvider(type = UserProvider.class, method = "buildSelectWithPagingSql")
    @ResultMap("userResultMap")
    List<User> select();



    @UpdateProvider(type = UserProvider.class, method = "buildDeletedById")
    void updateDeletedById(@Param("id") Integer id, @Param("status") Boolean status);

    @DeleteProvider(type = UserProvider.class, method = "deleteById")
    void deleteById(@Param("id") Integer id);

//    @UpdateProvider(type = UserProvider.class , method = "buildUpdateIsDelectedById")
//    void isDelete(@Param("id") Integer id ,@Param("s") boolean status);
    @SelectProvider(type = UserProvider.class, method = "selectUserSql")
    List<User> findAllUser();


    @Select("SELECT EXISTS(SELECT * FROM roles WHERE id=#{roleId})")
    boolean checkRoleId(Integer roleId);
}
