package com.muratArslan.cruddemo.rest;

import com.muratArslan.cruddemo.dao.EmployeeDao;
import com.muratArslan.cruddemo.entity.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeDao employeeDao;

    public EmployeeRestController(EmployeeDao theEmployeeDao){
        employeeDao=theEmployeeDao;
    }
    @GetMapping("/employees")
    public List<Employee> findEAll(){
        return employeeDao.findAll();
    }
}
