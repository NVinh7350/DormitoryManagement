package com.example.dormitorymanagement.service;

import com.example.dormitorymanagement.entity.Account;
import com.example.dormitorymanagement.entity.Student;
import com.example.dormitorymanagement.repository.AccountRepository;
import com.example.dormitorymanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService{
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void saveAcc(Account account) {
        accountRepository.save(account);
    }

    @Override
    public List<Account> getAllAccount() {
        return accountRepository.findAll();
    }

    @Override
    public Account getAccountByUsername(String username) {
        Optional<Account> optional = accountRepository.findById(username);
        Account account = null;
        if(optional.isPresent()){
            account = optional.get();
        } else {
            throw  new RuntimeException("Employee not found for id ::"+username);
        }
        return account;
    }

    @Override
    public void deleteAcc(String id) {
        accountRepository.deleteById(id);
    }

    @Override
    public List<Account> findAccount(String keyword) {
        if (keyword != null && keyword.length()>0) {
            return accountRepository.search(keyword);
        }

        return accountRepository.findAll();
    }
}
