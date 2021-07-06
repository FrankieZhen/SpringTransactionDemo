
package com.example.demo.controller;

import com.example.demo.dao.StudentMapper;
import com.example.demo.service.StudentService;
import com.example.demo.util.BizResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Date;

@RestController
@RequestMapping("/test2")
public class TransactionalController {

    @Autowired
    StudentService studentService;

    @Autowired
    StudentMapper studentMapper;

    //----------- 事务失效 ------------/


    /**
     * 非public方法失效
     */
    @RequestMapping("/demo1/{type}")
    public BizResponse demo1(@PathVariable int type) {
        studentService.notPublicMethodExtend(type);
        return BizResponse.success(new Date());
    }

    /**
     * 事务内try/catch
     */
    @RequestMapping("/demo2")
    public BizResponse demo2() {
        studentService.insertStudentTryCatch();
        return BizResponse.success(new Date());
    }

    /**
     * 事务外try/catch
     */
    @RequestMapping("/demo3")
    public BizResponse demo3() {
        try {
            studentService.insertStudentTryCatchOutside();
        } catch (Exception e) {
            System.out.println("异常已被事务外部捕获");
            return BizResponse.systemError();
        }
        return BizResponse.success(new Date());
    }

    /**
     * rollBackFor设置问题
     */
    @RequestMapping("/demo4")
    public BizResponse demo4() throws IOException {
        studentService.insertSetRollBackFor();
        return BizResponse.success(new Date());
    }

    /**
     * 自调用问题
     */
    @RequestMapping("/demo5/{type}")
    public BizResponse demo5(@PathVariable int type) {
        studentService.callSelfMethod(type);
        return BizResponse.success(new Date());
    }

    /**
     * 存储引擎不支持事务
     */
    @RequestMapping("/demo6")
    public BizResponse demo6() {
        studentService.insertNotSupportTransaction();
        return BizResponse.success(new Date());
    }

    /**
     * 非同一线程
     */
    @RequestMapping("/demo7/{type}")
    public BizResponse demo7(@PathVariable int type) {
        studentService.notSingleThread(type);
        return BizResponse.success(new Date());
    }


    //-------- 传播机制 ----/

    /**
     * type :  support、mandatory、requires_new
     */
    @RequestMapping("/demo8/{type}")
    public BizResponse demo8(@PathVariable int type) {
        studentService.callNoTransaction(type);
        return BizResponse.success(new Date());
    }


    /**
     * type:start from 0 { requires_new、not_support、never、nested }
     */
    @RequestMapping("/demo9/{type}")
    public BizResponse demo9(@PathVariable int type) {
        studentService.callWithTransaction(type);
        return BizResponse.success(new Date());
    }



    /**
     * 测试 Spring和DB的隔离级别
     */
    @RequestMapping("/demo10")
    public BizResponse demo10() {
        studentService.springIsolation();
        return BizResponse.success(new Date());
    }


}
