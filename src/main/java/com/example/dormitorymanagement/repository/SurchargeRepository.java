package com.example.dormitorymanagement.repository;

import com.example.dormitorymanagement.entity.Surcharge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SurchargeRepository extends JpaRepository<Surcharge, Integer> {
    List<Surcharge> findAllBySurchargeNameIsContaining(String value);
}
