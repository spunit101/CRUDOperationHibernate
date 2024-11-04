package com.spunit.service;

import com.spunit.model.Employee;

import java.util.List;

public interface EmployeeDao
{
    void saveEmployee(Employee student);
    void updateEmployee(Employee student);
    Employee getEmployeeById(long id);
    List<Employee> getAllEmployee();
    void deleteEmployee(long id);
}
