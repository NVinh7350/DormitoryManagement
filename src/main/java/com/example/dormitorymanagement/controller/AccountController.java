package com.example.dormitorymanagement.controller;

import com.example.dormitorymanagement.entity.Account;
import com.example.dormitorymanagement.entity.Employee;
import com.example.dormitorymanagement.entity.Student;
import com.example.dormitorymanagement.repository.AccountRepository;
import com.example.dormitorymanagement.service.AccountService;
import com.example.dormitorymanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller

public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/showAccountAddForm")
    public String showEmployeeAddForm(Model model){
        Account account = new Account();
        model.addAttribute("account", account);
        model.addAttribute("title", "THÊM TÀI KHOẢN");
        return "AddAccount";
    }

    @PostMapping("/saveAcc")
    public String saveAcc(@ModelAttribute("account") Account account) {
        accountService.saveAcc(account);
        return "redirect:/showAccountList";
    }

    @GetMapping("/showAccountList")
    public String showAccountList(Model model){
        List<Account> accounts = accountService.getAllAccount();
        model.addAttribute("accounts", accounts);
        model.addAttribute("title", "QUẢN LÝ TÀI KHOẢN");
        return "Accounts";
    }


    @GetMapping("/showAccountUpdateForm/{username}")
    public String showEmployeeUpdateForm(@PathVariable(value="username") String username, Model model){
        Account account = accountService.getAccountByUsername(username);
        model.addAttribute("account", account);
        model.addAttribute("title", "CẬP NHẬT TÀI KHOẢN");
        return "UpdateAccount";
    }


    @GetMapping("/deleteAccount/{username}")
    public String deleteStudent(@PathVariable(value="username") String username){
        accountService.deleteAcc(username);
        return "redirect:/showAccountList";
    }
    @GetMapping("/findAccount")
    public String showAccountList(Model model, @Param("keyword") String keyword){
        List<Account> accounts = accountService.findAccount(keyword);
        model.addAttribute("accounts", accounts);
        return "Accounts";
    }
}


