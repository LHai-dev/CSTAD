package com.example.spring4mbankingapisasu.auth;

import com.example.spring4mbankingapisasu.user.Role;
import com.example.spring4mbankingapisasu.user.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Mapper
@Repository
public interface AuthMapper {

  /**
    The buildRegisterSql method is defined as a public method that returns a String.

    */

 /**
  * @InsertProvider(type = AuthProvider.class, method = "buildRegisterSql"):
  * This annotation indicates that the SQL statement for registering a user
  * will be provided by the AuthProvider class's buildRegisterSql method.
  * @param user
  * @return
  */
 @InsertProvider(type = AuthProvider.class, method = "buildRegisterSql")
 /**
  * @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id"): This annotation specifies that the generated keys (if any)
  * should be used and mapped to the "id" field of the User object passed as a parameter to the register method.
  */
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    boolean register(@Param("u") User user);

    @Select("SELECT * FROM users WHERE email = #{email} AND is_deleted = FALSE")
    @Results(id = "authResult", value = {
            @Result(column = "id", property = "id"),
            @Result(column = "student_card_id", property = "studentCardId"),
            @Result(column = "is_student", property = "isStudent"),
            @Result(column = "is_verified", property = "isVerified"),
            @Result(column = "verified_code", property = "verifiedCode"),
            @Result(column = "password", property = "password"),
            @Result(column = "id", property = "roles", many = @Many(select = "loadUserRoles"))
    })
    Optional<User> selectByEmail(@Param("email") String email);

    @Select("SELECT * FROM users WHERE email = #{email} AND is_verified = TRUE")
    @ResultMap("authResult")
    Optional<User> loadUserByUserName(@Param("email") String email);

    @Select("SELECT EXISTS(SELECT *FROM users WHERE email = #{email} AND verified_code = #{code})")
    boolean checkIsVerified(@Param("email") String email, @Param("code") String verifiedCode);

    @UpdateProvider(type = AuthProvider.class, method = "UpdateCode")
    boolean updateIsVerified(@Param("email") String email, @Param("verifiedCode") String verifiedCode);

    @SelectProvider(type = AuthProvider.class, method = "buildSelectByEmailAndVerifiedCodeSql")
    @ResultMap("authResult")
    Optional<User> selectByEmailAndVerifiedCode(@Param("email") String email, @Param("verifiedCode") String verifiedCode);

    @UpdateProvider(type = AuthProvider.class, method = "updateIsVerified")
    void verify(@Param("email") String email, @Param("verifiedCode") String verifiedCode);

    @SelectProvider(value = AuthProvider.class, method = "buildLoadUserRolesSql")
    @Result(column = "id" , property = "authorities"
    ,many = @Many(select = "authorities"))
    List<Role> loadUserRoles(@Param("id") Integer userId);

    @SelectProvider(type = AuthProvider.class , method = "selectAuthorities")
    List<Authority> authorities(Integer roleId);
    @InsertProvider(value = AuthProvider.class, method = "buildInsertRoleSql")
    void insertRole(@Param("roleId") Integer role, @Param("userId") Integer user);

}
