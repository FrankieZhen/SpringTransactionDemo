package com.example.demo.service;

import com.example.demo.dao.StudentMapper;
import com.example.demo.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author xuchaozhen
 */
@Service
public class TestServiceImpl {


    @Autowired
    private static StudentMapper studentMapper;

    /**
     * static修饰方法
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    static void insertStudentStatic() {
        Student student = new Student().setSex(1).setName("static").setDesc("insertStudentStatic");
        studentMapper.insert(student);
            int i = 10 / 0;
    }
}
