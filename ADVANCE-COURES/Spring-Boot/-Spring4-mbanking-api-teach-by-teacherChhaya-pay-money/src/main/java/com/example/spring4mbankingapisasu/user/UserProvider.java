package com.example.spring4mbankingapisasu.user;


import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Repository;

@Repository
public class UserProvider {
    private final String USERS = "users";


    public String buildInsertUserSql(){
        return new SQL(){{
            INSERT_INTO(USERS);
            VALUES("name", "#{u.name}");
            VALUES("gender", "#{u.gender}");
            VALUES("is_deleted", "FALSE");
            VALUES("is_student", "#{u.isStudent}");
            VALUES("student_card_id", "#{u.studentCard}");
        }}.toString();
    }

    public String buildSelectByIdSql(){
        return new SQL(){{
            SELECT("*");
            FROM(USERS);
            WHERE("id = #{id}");
        }}.toString();
    }

    public String buildUpdateSql(){
        return new SQL(){{
            UPDATE(USERS);
            SET("name = #{u.name}");
            SET("gender = #{u.gender}");
            SET("is_student = #{u.isStudent}");
            SET("student_card_id = #{u.studentCard}");
            WHERE("id = #{u.id}");
        }}.toString();
    }


    public String selectUserSql(){
        return new SQL(){{
            SELECT("*");
            FROM(USERS);
        }}.toString();

    }

    public String buildSelectWithPagingSql(){
        return new SQL(){{
            SELECT("*");
            FROM(USERS);
            WHERE("is_deleted = FALSE");
        }}.toString();
    }
//        public String buildUpdateIsDelectedById(){
//        return new SQL(){
//            {
//                UPDATE(USERS);
//                SET("is_deleted = #{status}");
//                WHERE("id = #{id}");
//            }
//        }.toString();
//        }

    public String buildDeletedById(){
        return new SQL(){{
            UPDATE(USERS);
            SET("is_deleted=#{status}");
            WHERE("id=#{id}");
        }}.toString();
    }



    public String deleteById(){
        return new SQL(){{
            DELETE_FROM(USERS);
            WHERE("id = #{id}");
        }}.toString();
    }
}
