package com.example.demo.service;

import com.example.demo.NameConstant.NameConstant;
import com.example.demo.dao.UserMapper;
import com.example.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Random;

/**
 * @author xuchaozhen
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void insertUser() {
        User user = getNewUser();
        userMapper.insert(user);
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void insertUserWithException() {
        User user = getNewUser();
        userMapper.insert(user);
        int i = 1 / 0;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
    public void propagationSupports() {
        User user = getNewUser();
        userMapper.insert(user);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY, rollbackFor = Exception.class)
    public void propagationMandatory() {
        User user = getNewUser();
        userMapper.insert(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void propagationRequiresNew() {
        User user = getNewUser();
        userMapper.insert(user);
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED, rollbackFor = Exception.class)
    public void propagationNotSupported() {
        User user = getNewUser();
        userMapper.insert(user);
    }

    @Override
    @Transactional(propagation = Propagation.NEVER, rollbackFor = Exception.class)
    public void propagationNever() {
        User user = getNewUser();
        userMapper.insert(user);
    }

    @Override
    @Transactional(propagation = Propagation.NESTED, rollbackFor = Exception.class)
    public void propagationNested() {
        User user = getNewUser();
        userMapper.insert(user);
    }

    private User getNewUser() {
        Calendar calendar = Calendar.getInstance();
        User user = new User()
                .setName(NameConstant.NAME_LIST[calendar.get(Calendar.SECOND) / 6])
                .setAge(new Random().nextInt(100));

        System.out.println("User的信息：" + user.toString());
        return user;
    }
}
