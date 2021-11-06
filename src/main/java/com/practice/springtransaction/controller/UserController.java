package com.practice.springtransaction.controller;

import com.practice.springtransaction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author gaoyang
 * create on 2021/10/22
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findById")
    public void findByID(){
        userService.findById();
    }

    @RequestMapping("/insert")
    public void insert(){
        userService.insert();
    }

    @RequestMapping("/batchInsert")
    public void batchInsert(@RequestParam int i , @RequestParam int j){
        userService.batchInsert(i, j);
    }

    @RequestMapping("/insertTransaction")
    public void batchInsertTransactionchInsert(){
        userService.insertTransaction();
    }

    @DeleteMapping("/batchGet")
    public void batchGet(@RequestParam(value = "ids") List<String> ids){
        System.out.println("success");
    }




}
