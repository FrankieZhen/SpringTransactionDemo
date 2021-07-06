package com.example.demo.service;

/**
 * @author xuchaozhen
 */
public interface UserService {


    void insertUser();

    void insertUserWithException();

    void propagationSupports();

    void propagationMandatory();

    void propagationRequiresNew();

    void propagationNotSupported();

    void propagationNever();

    void propagationNested();

}
