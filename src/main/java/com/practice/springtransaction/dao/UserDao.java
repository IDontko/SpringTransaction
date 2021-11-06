package com.practice.springtransaction.dao;

import com.practice.springtransaction.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import javax.annotation.security.PermitAll;

/**
 * @author gaoyang
 * create on 2021/10/22
 */
@Mapper
public interface UserDao {

    @Select("select * from user where id = #{id}")
    User findById(@Param("id") int id);

    @Insert("insert into user values (#{id}, #{name}, #{age}, #{gender})")
    void insert(@Param("id") int id , @Param("name") String name, @Param("age") int age, @Param("gender") int gender);
}
