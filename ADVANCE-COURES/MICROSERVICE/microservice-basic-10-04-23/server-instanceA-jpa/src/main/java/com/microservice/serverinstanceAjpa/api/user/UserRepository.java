package com.microservice.serverinstanceAjpa.api.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    List<User> findByIsDeleteFalse();
    Optional<User> findByUuid(String uuid);

    List<User> findByName(String name);
    @Query("SELECT u FROM User AS u WHERE u.uuid = ?2 AND u.name = ?1")
    User findByUuidAndName(String name , String uuid);

    @Query("SELECT u.name FROM User AS u WHERE u.id = ?1")
    Optional<User> findNameById(Integer id);
}
