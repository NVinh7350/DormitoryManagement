package com.example.dormitorymanagement.repository;

import com.example.dormitorymanagement.entity.CheckInBill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CheckInBillRepository extends JpaRepository<CheckInBill, Integer> {
}
