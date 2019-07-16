package com.tw.apistackbase.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2019/7/16
 * @Time:15:38
 * @description:
 */
public class Employee implements Serializable {

    private int id;
    private String name;
    private String gender;
    private int age;


    public Employee(int id, String name, String gender, int age) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public static List<Employee> createEmployeesForTest(){
        List<Employee> list = new ArrayList<>();

        for(int i = 0;i < 10;i++){
            list.add(new Employee(i,"Leo" + i ,"male",10+i));
        }

        return list;

    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                '}';
    }


}
