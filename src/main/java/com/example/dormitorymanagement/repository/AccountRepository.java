package com.example.dormitorymanagement.repository;

import com.example.dormitorymanagement.entity.Account;
import com.example.dormitorymanagement.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, String> {
    @Query(nativeQuery = true, value = "Select * from account where user_name = :keyword")
    public List<Account> search(@Param("keyword") String keyword);

}
