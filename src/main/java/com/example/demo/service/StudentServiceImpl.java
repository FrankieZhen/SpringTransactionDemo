package com.example.demo.service;

import com.example.demo.NameConstant.NameConstant;
import com.example.demo.dao.StudentMapper;
import com.example.demo.pojo.Student;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;


/**
 * @author 徐朝圳
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private StudentService studentService;

    @Autowired
    private UserService userService;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
    public void baseInsertStudent() {
        Student student = getRandomStudent();
        studentMapper.insert(student);
        int i = 10 / 0;
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class, noRollbackFor = ArithmeticException.class)
    public void notPublicMethodExtend(int type) {

        switch (type) {
            case 0:
                insertStudentNotPublic();
                break;
            case 1:
                insertStudentFinal();
                break;
            case 2:
                TestServiceImpl.insertStudentStatic();
            default:
                break;
        }

    }

    /**
     * 方法非public修饰
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    private void insertStudentNotPublic() {
        Student student = getRandomStudent();
        studentMapper.insert(student);
        int i = 10 / 0;
    }

    /**
     * final修饰方法
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    final public void insertStudentFinal() {
        Student student = getRandomStudent();
        studentMapper.insert(student);
        int i = 10 / 0;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void insertStudentTryCatch() {
        Student student = getRandomStudent();
        studentMapper.insert(student);
        try {
            int i = 10 / 0;
        }catch (Exception e){
            System.out.println("异常已被事务内部捕获");
        }
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void serviceCallService() {
        Student student = getRandomStudent();
        studentMapper.insert(student);
        userService.insertUser();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
    public void insertSetRollBackFor() throws IOException {
        Student student = getRandomStudent();
        throw new IOException();
    }

    @Override
    public void callSelfMethod(int type) {
        Student student = getRandomStudent();

        switch (type) {
            case 0:
                this.baseInsertStudent();
                break;
            case 1:
                studentService.baseInsertStudent();
                break;
            case 2:
                StudentService service = (StudentService) AopContext.currentProxy();
//        StudentServiceImpl service = (StudentServiceImpl) AopContext.currentProxy();
                service.baseInsertStudent();
                break;
            default:
                break;
        }

    }

    /**
     * 表存储引擎是 MyISAM
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void insertNotSupportTransaction() {
        Student student = getRandomStudent();
        studentMapper.insertToMyISAM(student);
        int i = 10 / 0;
    }


    /**
     * 非同一线程
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void notSingleThread(int type) {
        Student student = getRandomStudent();
        studentMapper.insert(student);
        if (type == 1) {
            //新起一条线程
            new Thread(() -> userService.insertUser()).start();
        } else {
            asyncInsertStudent();
        }

        int i = 10 / 0;
    }

    @Async
    public void asyncInsertStudent() {
        Student student = getRandomStudent();
        studentMapper.insert(student);
    }

    private Student getRandomStudent() {

        Calendar calendar = Calendar.getInstance();
        Student student = new Student()
                .setSex(calendar.getTimeInMillis() % 2 == 1 ? 1 : 2)
                .setName(NameConstant.NAME_LIST[calendar.get(Calendar.SECOND) / 6])
                .setDesc("创建时间：" + calendar.getTime());

        System.out.println("Student的信息：" + student.toString());
        return student;
    }

    @Override
    public List<Student> getStudentList() {
        return studentMapper.getStudentList();
    }

    @Override
    public void callNoTransaction(int type) {
        switch (type) {
            case 0:
                userService.propagationSupports();
                break;
            case 1:
                userService.propagationMandatory();
                break;
            case 2:
                userService.propagationRequiresNew();
                break;
            default:
                break;
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void callWithTransaction(int type) {
        Student student = getRandomStudent();
        studentMapper.insert(student);
        switch (type) {
            case 0:
                userService.propagationRequiresNew();
                break;
            case 1:
                userService.propagationNotSupported();
                break;
            case 2:
                userService.propagationNever();
                break;
            case 3:
                userService.propagationNested();
                break;
            default:
                break;
        }
        int i = 1 / 0;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class,isolation = Isolation.READ_COMMITTED)
    public void springIsolation() {
        List<Student> studentList1 = studentMapper.getStudentList();
        System.out.println(studentList1);


        List<Student> studentList2 = studentMapper.getStudentList();
        System.out.println(studentList2);

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
    public void insertStudentTryCatchOutside() throws Exception {
        Student student = getRandomStudent();
        studentMapper.insert(student);
        int i = 10 / 0;
    }
}