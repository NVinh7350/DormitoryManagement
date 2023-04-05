package com.example.dormitorymanagement.repository;

import com.example.dormitorymanagement.entity.Contract;
import com.example.dormitorymanagement.entity.Employee;
import com.example.dormitorymanagement.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ContractRepository extends JpaRepository<Contract,Integer> {
}
