package co.istad.mbanking.api.user;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Mapper
public interface UserMapper {
    @InsertProvider(type = UserProvider.class, method = "buildInsert")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void insert(@Param("u") User user);

    @SelectProvider(type = UserProvider.class, method = "buildInsertById")
    @Results(id = "userResultMap", value = {
            @Result(column = "student_card_id", property = "studentCard"),
            @Result(column = "is_student", property = "isStudent")
    })
    Optional<User> selectById(@Param("id") Integer id);

    @Select("SELECT EXISTS(SELECT * FROM users WHERE id = #{id})")
    Boolean existById(@Param("id") Integer id);

    @DeleteProvider(type = UserProvider.class, method = "buildDeleteByIdSql")
    void deleteById(@Param("id") Integer id);

    @UpdateProvider(type = UserProvider.class, method = "buildUpdateIsDeletedById")
    void updateIsDeletedById(@Param("id") Integer id, @Param("status") boolean status);

    @SelectProvider(type = UserProvider.class, method = "buildSelectSQL")
    @ResultMap("userResultMap")
    List<User> select();

    @UpdateProvider(type = UserProvider.class, method = "buildUpdateByIdSql")
    void updateById(@Param("u") User user);



    //search by name and STUDENT CARD ID
    @SelectProvider(type = UserProvider.class, method = "searchUserByName")
    @ResultMap("userResultMap")
    List<User> searchUserByName(@Param("n")UserBySearchByName searchByName);
    @SelectProvider(type = UserProvider.class, method = "searchUserByStudentCardId")
    @ResultMap("userResultMap")
    List<User> searchUserByStudentCardId(@Param("ci") StudentIdCardDto studentCardIDDto);
}
