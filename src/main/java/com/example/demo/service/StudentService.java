package com.example.demo.service;

import com.example.demo.pojo.Student;

import java.io.IOException;
import java.util.List;

/**
 * @author xuchaozhen
 */
public interface StudentService {

    List<Student> getStudentList();

    void baseInsertStudent();

    /**
     * @param type 0-非public，1-final，2-static
     */
    void notPublicMethodExtend(int type);

    void insertStudentTryCatch();

    void serviceCallService();

    void insertSetRollBackFor() throws IOException;

    /**
     * @param type 0-自调用，1-自注入调用，2-获取代理类调用
     */
    void callSelfMethod(int type);

    void insertNotSupportTransaction();

    void notSingleThread(int type);

    void callNoTransaction(int type);

    void callWithTransaction(int type);

    void springIsolation();

    void insertStudentTryCatchOutside() throws Exception;

    void springIsolation2();

    void callWithTransactionNest();

}
