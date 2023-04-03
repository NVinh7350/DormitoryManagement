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
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private AccountRepository accountRepository;
    @GetMapping("/showEmployeeAddForm")
    public String showEmployeeAddForm(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "EmployeeForm";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        Account account = new Account(employee.getEmployeeId(), employee.getEmployeeId(), employee.getAccountType());;
        accountRepository.save(account);
        employee.setAccount(account);
        employeeService.saveEmployee(employee);
        return "redirect:/employee/showEmployeeList";
    }

    @GetMapping("/showEmployeeUpdateForm/{id}")
    public String showEmployeeUpdateForm(@PathVariable(value="id") String id, Model model){
        Employee employee = employeeService.getElementById(id);
        model.addAttribute("employee", employee);
        return "EmployeeForm";
    }


    @PutMapping("/saveEmployee")
    public String updateEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.saveEmployee(employee);
        return "redirect:/employee/showEmployeeList";
    }

    @GetMapping("/showEmployeeList")
    public String showEmployeeFilterList(Model model){
        List<Employee> employeeList = employeeService.getAllEmployee();
        model.addAttribute("employeeList", employeeList);
        return "Employees";
    }

    @GetMapping("/showEmployeeFilterList")
    @ResponseBody
    public List<Employee> showEmployeeFilterList(Model model,@RequestParam String keyword , @RequestParam String accountType){
        List<Employee> employeeList = null;
        System.out.println(keyword.equals(""));
        System.out.println(keyword);
        System.out.println(accountType == null );
        if(!keyword.equals("")){
            employeeList = employeeService.filterAllEmployeeByNameOrId(keyword,accountType);
        } else {
            employeeList = employeeService.filterAllEmployee(accountType);
        }
        model.addAttribute("employeeList", employeeList);
        return employeeList;
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable(value="id") String id){
        employeeService.deleteEmployeeById(id);
        return "redirect:/employee/showEmployeeList";
    }
}
