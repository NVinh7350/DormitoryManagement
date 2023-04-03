package com.example.dormitorymanagement.service;

import com.example.dormitorymanagement.entity.Employee;
import com.example.dormitorymanagement.entity.Student;
import com.example.dormitorymanagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;
    @Override
    public void saveStudent(Student student) {
         studentRepository.save(student);
    }
    @Override
    public List<Student> getAllStudents() {
         return studentRepository.findAll();
    }

    @Override
    public Student getElementById(String id) {
        Optional<Student> optional = studentRepository.findById(id);
        Student student = null;
        if(optional.isPresent()){
            student = optional.get();
        } else {
            throw  new RuntimeException("Employee not found for id ::"+id);
        }
        return student;
    }
    @Override
    public void deleteStudentById(String id) {
        studentRepository.deleteById(id);
    }

    public List<Student> findStudentByName(String keyword) {
        System.out.println(keyword);
        System.out.println(keyword.length());

        if (keyword != null && keyword.length()>0) {
            return studentRepository.search(keyword);
        }

        return studentRepository.findAll();
    }
}
