package com.example.dormitorymanagement.service;
import com.example.dormitorymanagement.entity.Student;

import java.util.List;

public interface StudentService {
    public void saveStudent(Student student);

    public List<Student> getAllStudents();

    public Student getElementById(String id);
    public void deleteStudentById(String id);

    public List<Student> findStudentByName(String keyword);
}
