package com.example.dormitorymanagement.controller;

import com.example.dormitorymanagement.entity.Account;
import com.example.dormitorymanagement.entity.Employee;
import com.example.dormitorymanagement.repository.AccountRepository;
import com.example.dormitorymanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private AccountRepository accountRepository;
    @GetMapping("/showEmployeeAddForm")
    public String showEmployeeAddForm(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "AddEmployee";
    }

    @GetMapping("/showEmployeeUpdateForm/{id}")
    public String showEmployeeUpdateForm(@PathVariable(value="id") String id, Model model){
        Employee employee = employeeService.getElementById(id);
        model.addAttribute("employee", employee);
        return "UpdateEmployee";
    }



    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        Account account = new Account(employee.getEmployeeName(), employee.getEmployeeName(), employee.getAccountType());
        accountRepository.save(account);
        employee.setAccount(account);
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/showEmployeeList")
    public String showEmployeeList(Model model){
        List<Employee> employeeList = employeeService.getAllEmployee();
        model.addAttribute("employeeList", employeeList);
        return "Employees";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmloyee(@PathVariable(value="id") String id){
        employeeService.deleteEmployeeById(id);
        return "redirect:/";
    }
}
