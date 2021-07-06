
package com.example.demo.controller;

import com.example.demo.pojo.Student;
import com.example.demo.service.StudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class PageHelperController {

    @Autowired
    StudentService studentService;

    @RequestMapping("/demo1/{pageNum}/{pageSize}")
    public PageInfo<Student> getStudentPage(@PathVariable int pageNum, @PathVariable int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Student> studentList = studentService.getStudentList();
        return new PageInfo<>(studentList);
    }

    @RequestMapping("/demo2/{pageNum}/{pageSize}")
    public PageInfo<Student> demo2(@PathVariable int pageNum, @PathVariable int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return null;
    }

    @RequestMapping("/demo3")
    public List<Student> demo3() {
        return studentService.getStudentList();
    }


    @RequestMapping("/demo4")
    public Boolean demo4() {
        Map<String,String> map = null;
        return StringUtils.isEmpty(map);
    }

}
