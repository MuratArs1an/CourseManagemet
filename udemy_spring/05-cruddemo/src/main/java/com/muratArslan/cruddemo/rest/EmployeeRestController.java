package com.muratArslan.cruddemo.rest;

import com.muratArslan.cruddemo.entity.Employee;
import com.muratArslan.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;
    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findEAll(){
        return employeeService.findAll();
    }
    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable("employeeId") int id){
        Employee theEmployee= employeeService.findById(id);
        if(theEmployee==null){
            throw new RuntimeException("Employee does not exist");
        }
        return theEmployee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){
    //force save
        theEmployee.setId(0);
        Employee dbEmployee=employeeService.save(theEmployee);
        return  dbEmployee;
    }

}
