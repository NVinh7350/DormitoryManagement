package com.example.dormitorymanagement.repository;

import com.example.dormitorymanagement.entity.Employee;
import com.example.dormitorymanagement.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, String> {

    @Query(nativeQuery = true, value = "Select * from student where student_name = :keyword")
    public List<Student> search(@Param("keyword") String keyword);
}
