package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.Company;
import com.tw.apistackbase.model.Employee;
import org.springframework.web.bind.annotation.*;
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


    @GetMapping(params = {"page", "pageSize"})
    public List<Company> getCompaniesByPaging(@RequestParam("page")int page,
                                              @RequestParam("pageSize")int pageSize){

        int startIndex = (page - 1) * pageSize;
        int end = startIndex + pageSize;

        List<Company> result = new ArrayList<>();
        for (int i = startIndex;i < end && i < list.size();i++){
            result.add(this.list.get(i));
        }

        return result;
    }


    @GetMapping("/{id}/employees")
    public List<Employee> getEmployeesByCompanyId(@PathVariable int id){

        Company company = list.get(id);
        List<Employee> result = company.getEmployees();

        return result;
    }



}
