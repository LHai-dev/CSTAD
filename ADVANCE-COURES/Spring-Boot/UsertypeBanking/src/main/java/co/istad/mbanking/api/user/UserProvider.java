package co.istad.mbanking.api.user;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Repository;

@Repository
public class UserProvider {
    private final String tableName = "users";

    public String buildInsert(@Param("u") User user) {
        return new SQL() {{
            INSERT_INTO(tableName);
            VALUES("name", "#{u.name}");
            VALUES("gender", "#{u.gender}");
            VALUES("one_signal_id", "#{u.oneSignal}");
            VALUES("student_card_id", "#{u.studentCard}");
            VALUES("is_student", "#{u.isStudent}");
        }}.toString();
    }

    public String buildInsertById() {
        return new SQL() {{
            SELECT("*");
            FROM(tableName);
            WHERE("id = #{id}");
        }}.toString();
    }

    public String buildDeleteByIdSql() {
        return new SQL() {{
            DELETE_FROM(tableName);
            WHERE("id = #{id}");
        }}.toString();
    }

    public String buildUpdateIsDeletedById() {
        return new SQL() {{
            UPDATE(tableName);
            SET("is_deleted = #{status}");
            WHERE("id = #{id}");
        }}.toString();
    }

    public String buildSelectSQL() {
        return new SQL() {{
            SELECT("*");
            FROM(tableName);
            WHERE("is_deleted = FALSE");
            ORDER_BY("id DESC");
        }}.toString();
    }

    public String buildUpdateByIdSql() {
        return new SQL() {{
            UPDATE(tableName);
            SET("name = #{u.name}");
            SET("gender = #{u.gender}");
            WHERE("id = #{u.id}");
        }}.toString();}
        //search by name and studentCardId
        public String searchUserByName(){
            return new SQL(){{
                SELECT("*");
                FROM(tableName);
                WHERE("name iLIKE '%' || #{n.name} || '%'");
            }}.toString();
        }
        public String searchUserByStudentCardId(){
            return new SQL(){{
                SELECT("*");
                FROM(tableName);
                WHERE("student_card_id = #{ci.cardId}");
            }}.toString();
        }
}
