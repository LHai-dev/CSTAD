package co.istad.mbanking.api.accounttype;


import co.istad.mbanking.api.user.User;
import co.istad.mbanking.api.user.UserProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.awt.*;
import java.util.List;
import java.util.Optional;

@Repository
@Mapper
public interface AccountTypeMapper {
    @SelectProvider(type = AccountTypeProvider.class , method = "buildSelectSQL")
    List<AccountType> select();



    @InsertProvider(type = AccountTypeProvider.class, method = "buildInsertSql")
    @Options(useGeneratedKeys = true, keyColumn = "id",keyProperty = "id")
    void insert(@Param("a") AccountType accountType);

    @SelectProvider(type = AccountTypeProvider.class, method = "buildSelectById")
    @Results(id = "accountTypeResultMap", value = {
            @Result(column = "id", property = "id"),
            @Result(column = "name", property = "name")
    })
    Optional<AccountType> selectById(Integer id);

    @Select("SELECT EXISTS(SELECT * FROM account_types WHERE id=#{id} AND is_deleted = FALSE)")
    boolean existUserById(@Param("id") Integer id);

    @DeleteProvider(type = AccountTypeProvider.class, method = "buildDeleteByIdSql")
    void deleteById(Integer id);


    @UpdateProvider(type = AccountTypeProvider.class,method = "buildUpdateSql")
    void updateById(@Param("act") AccountType accountType);

}
