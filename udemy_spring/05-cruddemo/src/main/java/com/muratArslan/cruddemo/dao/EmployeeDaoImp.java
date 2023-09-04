package com.muratArslan.cruddemo.dao;

import com.muratArslan.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImp implements EmployeeDao {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDaoImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

     @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> theQuery=entityManager.createQuery("from Employee",Employee.class);
        List<Employee> employees=theQuery.getResultList();
        return employees;
    }

    @Override
    public Employee findById(int id) {
        Employee employee=entityManager.find(Employee.class,id);
        return employee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        Employee dbEmployee=entityManager.merge(theEmployee);
        return dbEmployee;
    }

    @Override
    public void deleteById(int id) {
        Employee theEmployee=entityManager.find(Employee.class,id);
        entityManager.remove(theEmployee);
     }
}
