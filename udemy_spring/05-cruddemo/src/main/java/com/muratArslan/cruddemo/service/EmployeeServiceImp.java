package com.muratArslan.cruddemo.service;

import com.muratArslan.cruddemo.dao.EmployeeDao;
import com.muratArslan.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImp implements EmployeeService{
    private EmployeeDao employeeDao;

    @Autowired
    public EmployeeServiceImp(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }
}
