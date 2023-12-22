package com.example.spring4mbankingapisasu.auth;

import org.apache.ibatis.jdbc.SQL;

public class AuthProvider {

    /*
    *    Within the method, an instance of the SQL class is
    created using double curly braces ({{}}) to define
    an anonymous inner class.
     */
    public String buildRegisterSql() {
        return new SQL() {{
            /**
             * The INSERT_INTO method of the SQL instance
             * is called with the argument "users"
             * to specify the table name.
             */
            INSERT_INTO("users");
            /**
             * The VALUES method is called multiple times
             * with column names and their corresponding
             * values as arguments.
             *
             * "email" and "#{u.email}" represent the column name and the value to be inserted
             * , respectively. The #{u.email} notation suggests the value is a placeholder
             * to be replaced with an actual value during runtime.
             */
            VALUES("email", "#{u.email}");

            /**
             * Similarly, "password", "#{u.password}"
             * , "is_verified", and "#{u.isVerified}"
             * are column-value pairs to be inserted.
             */
            VALUES("password", "#{u.password}");
            VALUES("is_verified", "#{u.isVerified}");
            /**
             * "is_deleted" is set to the constant value "FALSE".
             */
            VALUES("is_deleted", "FALSE");
        }}.toString();
        /**
         * Finally, the toString method is called on the SQL instance,
         * which generates the complete SQL INSERT statement as a String and returns it.
         */


    }

    public String insertSql() {
        return new SQL() {{
            UPDATE("users");
            SET("verified_code = #{code}");
            SET("is_verified = TRUE");
            WHERE("email = #{email}");
        }}.toString();
    }

    public String buildSelectByEmailAndVerifiedCodeSql() {
        return new SQL() {{
            SELECT("*");
            FROM("users");
            WHERE("email = #{email}","verified_code = #{verifiedCode}");
        }}.toString();
    }

    public String updateIsVerified() {
        return new SQL() {{
            UPDATE("users");
            SET("is_verified=TRUE");
            SET("verified_code=NULL");
            WHERE("email = #{email}  AND verified_code = #{verifiedCode}");
        }}.toString();
    }

    public String UpdateCode() {
        return new SQL() {{
            UPDATE("users");
            SET("verified_code = #{verifiedCode}");
            WHERE("email = #{email}");
        }}.toString();
    }

    public String buildLoadUserRolesSql() {
        return new SQL() {{
            SELECT("r.id, r.name");
            FROM("roles AS r");
            INNER_JOIN("users_roles AS ur ON r.id = ur.role_id");
            WHERE("ur.user_id = #{id}");
        }}.toString();
    }

    public String buildInsertRoleSql() {
        return new SQL() {{
            INSERT_INTO("users_roles");
            VALUES("user_id", "#{userId}");
            VALUES("role_id", "#{roleId}");
        }}.toString();
    }

    public String selectAuthorities(){
        return new SQL(){{
            SELECT("a.id,a.name");
            FROM("authorities AS a");
            INNER_JOIN("roles_authorities AS ra ON ra.authority_id = a.id");
            WHERE("ra.role_id=#{roleId}");
        }}.toString();
    }
}
