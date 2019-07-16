package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.Company;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2019/7/16
 * @Time:21:35
 * @description:
 */

@RestController
@RequestMapping("/companies")
public class CompanyController {

    List<Company> list = new ArrayList<>();

    public CompanyController(){
        list.addAll(Company.createCompaniesForTest());
    }

    @GetMapping
    public List<Company> getCompanies() {

        return list;

    }

    @GetMapping("/{id}")
    public Company getCompany(@PathVariable int id){

        Company company = null;

        for (Company temp:list){
            if (id == temp.getId()){
                company = temp;
                break;
            }
        }

        return company;
    }


}
