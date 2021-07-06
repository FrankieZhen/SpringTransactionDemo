
package com.example.demo.dao;

import com.example.demo.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author xuchaozhen
 * @since 2020-10-22
 **/
@Mapper
public interface UserMapper {


    @Insert("insert into user (`name`,`age`) values (#{name}, #{age})")
    void insert(User user);

}
