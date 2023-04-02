package com.example.dormitorymanagement.repository;

import com.example.dormitorymanagement.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {
}
