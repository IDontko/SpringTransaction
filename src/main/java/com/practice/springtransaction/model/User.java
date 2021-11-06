package com.practice.springtransaction.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author gaoyang
 * create on 2021/10/22
 */
@Data
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private int age;
    private int gender;

}
