package com.pack.dao;

import com.pack.po.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserDao extends JpaRepository<User,Long> {

    @Query(value = "select * from user u where u.name = :name",nativeQuery = true)
    User selectUser(@Param("name") String name);


}
