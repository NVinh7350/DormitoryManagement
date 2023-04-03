package com.example.dormitorymanagement.repository;

import com.example.dormitorymanagement.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, String> {

}
