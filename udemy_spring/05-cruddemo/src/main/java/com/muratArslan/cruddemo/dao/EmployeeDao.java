package com.muratArslan.cruddemo.dao;

import com.muratArslan.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    List<Employee> findAll();
}
