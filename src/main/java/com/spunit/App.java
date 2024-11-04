package com.spunit;

import com.spunit.model.Employee;
import com.spunit.service.EmployeeDaoImpl;

import java.util.List;

public class App
{
    private static final String FIRST_NAME = "Punit";
    private static final String LAST_NAME = "Shirsal";
    private static final String EMAIL = "punitshirsal@gmail.com";

    public static void main(String[] args)
    {
        EmployeeDaoImpl employeeDaoImpl = new EmployeeDaoImpl();

        Employee employee = new Employee(FIRST_NAME, LAST_NAME, EMAIL);
        employeeDaoImpl.saveEmployee(employee);

        employee.setFirstName(FIRST_NAME);
        employeeDaoImpl.updateEmployee(employee);

        Employee employee2 = employeeDaoImpl.getEmployeeById(employee.getId());
        System.out.println(employee2);

        List<Employee> employeeList = employeeDaoImpl.getAllEmployee();
        employeeList.forEach(e -> System.out.println(e.getId()));

        employeeDaoImpl.deleteEmployee(employee.getId());
    }
}
