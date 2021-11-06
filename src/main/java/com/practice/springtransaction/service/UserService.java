package com.practice.springtransaction.service;

import com.practice.springtransaction.dao.UserDao;
import com.practice.springtransaction.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author gaoyang
 * create on 2021/10/22
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;


    public void findById() {
        User user = userDao.findById(1);
        System.out.println(user);
    }

    public void insert() {
        userDao.insert(11, "张三", 12, 1);
    }


    /**
     * 一个事务中。如果存在循环，发生错误，循环中的所有逻辑都会 回滚。
     * @param i
     * @param j
     */
    @Transactional(rollbackFor = Exception.class)
    public void batchInsert(int i, int j) {
        for (int k = i; k < j; k++) {
            userDao.insert(k, "张三", 12, 1);
        }
    }

    /**
     * 一个类中，A方法调用B方法
     * A方法中有事务声明，如果B方法也有事务声明，则B方法事务声明不会生效, ，Spring采用动态代理(AOP)实现对bean的管理和切片，
     * 它为我们的每个class生成一个代理对象。只有在代理对象之间进行调用时，可以触发切面逻辑。同一个类中调用的是原对象的方法，而
     * 不通过代理对象，所以Spring无法切到这次调用，所以就无法通过注解保证事务性了。
     */
    @Transactional(rollbackFor = Exception.class)
    public void insertTransaction(){
        userDao.insert(20, "张三", 12, 1);
        insertTransactionError();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    public void insertTransactionError(){
        try{
            userDao.insert(21, "张三", 12, 1);
        }catch (Exception e){
            System.out.println("抓住异常");
        }

//        throw new RuntimeException("错误");

    }
}
