
package com.example.demo.dao;

import com.example.demo.pojo.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author xuchaozhen
 * @since 2020-10-22
 **/
@Mapper
public interface StudentMapper {

    @Select("select * from student")
    List<Student> getStudentList();

    @Insert("insert into student (`name`,`sex`,`desc`) values (#{name}, #{sex}, #{desc})")
    void insert(Student student);

    @Insert("insert into student_two (`name`,`sex`,`desc`) values (#{name}, #{sex}, #{desc})")
    void insertToMyISAM(Student student);
}
