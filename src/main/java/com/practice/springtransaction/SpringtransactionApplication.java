package com.practice.springtransaction;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
//@MapperScan("com.practice.springtransaction.dao.UserDao")
public class SpringtransactionApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringtransactionApplication.class, args);
    }

}
