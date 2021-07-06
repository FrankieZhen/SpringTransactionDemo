
package com.example.demo.controller;

import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test2")
public class RestFulController {

    @Autowired
    StudentService studentService;


    @RequestMapping("/demo")
    public Boolean demo() {
        System.out.println("demo4");
        return true;
    }

    @PostMapping("/demo")
    public Boolean demo1() {
        System.out.println("demo1");
        return true;
    }

    @GetMapping("/demo")
    public Boolean demo2() {
        System.out.println("demo2");
        return true;
    }

    @GetMapping("/demo/{num}")
    public Boolean demo3(@PathVariable int num) {
        System.out.println("demo3,num = " + num);
        return true;
    }


    @PostMapping("/demo/{num}")
    public Boolean demo4(@PathVariable int num) {
        System.out.println("demo4,num = " + num);
        return true;
    }

}
