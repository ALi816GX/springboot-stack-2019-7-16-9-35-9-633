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
 * @Time:15:35
 * @description:
 */

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    List<Employee> list = new ArrayList<>();

    public EmployeeController(){
        list.addAll(Employee.createEmployeesForTest());
    }

    @GetMapping
    public List<Employee> getEmployees(){
        return list;
    }


    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable int id){

        Employee employee = null;

        for (Employee temp:list){
            if (id == temp.getId()){
                employee = temp;
                break;
            }
        }

        return employee;
    }

    @GetMapping(params = {"page", "pageSize"})
    public List<Employee> getEmployeesByPaging(@RequestParam("page")int page,
                                               @RequestParam("pageSize")int pageSize){

        int startIndex = (page - 1) * pageSize;
        int end = startIndex + pageSize;

        List<Employee> result = new ArrayList<>();
        for (int i = startIndex;i < end && i < list.size();i++){
            result.add(this.list.get(i));
        }

        return result;
    }




}
