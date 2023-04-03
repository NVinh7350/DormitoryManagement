package com.example.dormitorymanagement.service;

import com.example.dormitorymanagement.entity.Employee;
import com.example.dormitorymanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getElementById(String id) {
        Optional<Employee> optional = employeeRepository.findById(id);
        Employee employee = null;
        if(optional.isPresent()){
            employee = optional.get();
        } else {
            throw  new RuntimeException("Employee not found for id ::"+id);
        }
        return employee;
    }
    @Override
    public void deleteEmployeeById(String id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> filterAllEmployeeByNameOrId(String value, String accountType) {
        List<Employee> employees = employeeRepository.findAllByEmployeeNameContainingOrEmployeeIdContaining(value, value);
        if(accountType.equals("all"))
            return employees;
        List<Employee> subEmployees = new ArrayList<>();
        for(Employee e : employees){
            if(e.getAccount().getAccountType().equals(accountType)){
                subEmployees.add(e);
            }
        }
        return subEmployees;
    }

    @Override
    public List<Employee> filterAllEmployee(String accountType) {
        List<Employee> employees = employeeRepository.findAll();
        if(accountType.equals("all"))
            return employees;
        List<Employee> subEmployees = new ArrayList<>();
        for(Employee e : employees){
            if(e.getAccount().getAccountType().equals(accountType)){
                subEmployees.add(e);
            }
        }
        return subEmployees;
    }
}
