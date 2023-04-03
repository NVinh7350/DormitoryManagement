package com.example.dormitorymanagement.service;

import com.example.dormitorymanagement.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public void saveEmployee(Employee employee);

    public List<Employee> getAllEmployee();
    public Employee getElementById(String id);
    public void deleteEmployeeById(String id);
    public List<Employee> filterAllEmployeeByNameOrId(String value, String accountType);

    public List<Employee> filterAllEmployee(String accountType);
}
