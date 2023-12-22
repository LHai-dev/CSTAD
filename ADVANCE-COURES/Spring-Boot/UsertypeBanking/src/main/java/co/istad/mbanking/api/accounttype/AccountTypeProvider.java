package co.istad.mbanking.api.accounttype;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public class AccountTypeProvider {

    private final String tableName = "account_types";

    public String buildSelectSQL(){
        return new SQL(){{
            SELECT("*");
            FROM(tableName);
        }}.toString();
    }

    public String buildInsertSql() {
        return new SQL() {{
            INSERT_INTO(tableName);
            VALUES("name", "#{a.name}");
        }}.toString();
    }



    public String buildSelectById(){
        return new SQL(){{
            SELECT("*");
            FROM(tableName);
            WHERE("id = #{id}","is_deleted = FALSE");
        }}.toString();
    }

    public String buildDeleteByIdSql(){
        return new SQL(){{
            UPDATE(tableName);
            SET("is_deleted = TRUE");
            WHERE("id = #{id}");
        }}.toString();
    }

    public String buildUpdateSql(){
        return new  SQL(){{
            UPDATE(tableName);
            SET("name=#{act.name}");
            WHERE("id = #{act.id}");
        }}.toString();
    }

}
