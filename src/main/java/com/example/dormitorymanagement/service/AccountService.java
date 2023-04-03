package com.example.dormitorymanagement.service;

import com.example.dormitorymanagement.entity.Account;
import com.example.dormitorymanagement.entity.Employee;
import com.example.dormitorymanagement.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountService {
    public void saveAcc(Account account);

    public List<Account> getAllAccount();
    public Account getAccountByUsername(String username);
    public void deleteAcc(String id);
    public List<Account> findAccount(String keyword);


}
