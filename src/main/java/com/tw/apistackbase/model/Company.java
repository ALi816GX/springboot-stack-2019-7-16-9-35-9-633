package com.tw.apistackbase.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2019/7/16
 * @Time:21:38
 * @description:
 */
public class Company {

    private int id;
    private String name;
    private int age;
    private List<Employee> employees;


    public Company() {
    }

    public Company(int id, String name, int age) {
        this.id = id;
        this.name = name;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public static List<Company> createCompaniesForTest(){

        List<Employee> employees = new ArrayList<>();
        for(int i = 0;i < 3;i++){
            employees.add(new Employee(i,"Leo" + i ,"male",10+i));
        }


        List<Company> list = new ArrayList<>();
        for(int i = 0;i < 10;i++){
            list.add(new Company(i,"OOCL" + i ,i));
        }


        list.get(0).setEmployees(employees);

        return list;

    }
}
