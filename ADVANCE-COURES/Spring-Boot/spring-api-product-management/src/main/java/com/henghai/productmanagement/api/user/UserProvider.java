package com.henghai.productmanagement.api.user;

import org.apache.ibatis.jdbc.SQL;

public class UserProvider {
    public String buildSelectUserSql() {
        return new SQL() {
            {
                SELECT("*");
                FROM("users");
            }
        }.toString();
    }
    public String buildInsertUserSql(){
        return new SQL(){{
            INSERT_INTO("users");
            VALUES("user_name","#{u.name}");
            VALUES("dob","#{u.dob}");
            VALUES("gender","#{u.gender}");
            VALUES("phone_number","#{u.phoneNumber}");
            VALUES("password","#{u.password}");
            VALUES("email","#{u.email}");
            VALUES("address","#{u.address}");
            VALUES("is_verified","#{u.isVerified}");
            VALUES("status","#{u.status}");
        }}.toString();


    }
    public String buildDeleteByIdSql(){
        return new SQL(){{
            DELETE_FROM("users");
            WHERE("id=#{id}");
        }}.toString();

    }
    public String buildSelectById(){
        return new SQL(){{
            SELECT("*");
            FROM("users");
            WHERE("id = #{id}");
        }}.toString();
    }
    public String buildUpdateUserSql(){
        return new SQL(){{
            UPDATE("users");
            SET("user_name=#{user.name}");
            SET("dob=#{user.dob}");
            SET("gender=#{user.gender}");
            SET("phone_number=#{user.phoneNumber}");
            SET("password=#{user.password}");
            SET("address=#{user.address}");
            SET("is_verified=#{user.isVerified}");
            SET("status=#{user.status}");
            WHERE("id=#{user.id}");
        }}.toString();
    }
}
