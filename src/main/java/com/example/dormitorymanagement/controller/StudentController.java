package com.example.dormitorymanagement.controller;

import com.example.dormitorymanagement.entity.Account;
import com.example.dormitorymanagement.entity.Employee;
import com.example.dormitorymanagement.entity.Student;
import com.example.dormitorymanagement.service.AccountService;
import com.example.dormitorymanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;


    @GetMapping("/registerRoom")
    public String showRegisterRoom(Model model){
        Student student=new Student();
        model.addAttribute("student", student);
        return "RegisterRoom";
    }

    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/showStudentList";
    }

    @GetMapping("/showStudentList")
    public String showStudentList(Model model){
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "students";
    }




    @GetMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable(value="id") String id){
        studentService.deleteStudentById(id);
        return "redirect:/showStudentList";
    }


    @GetMapping("/showStudentUpdateForm/{id}")
    public String showEmployeeUpdateForm(@PathVariable(value="id") String id, Model model){
        Student student = studentService.getElementById(id);
        model.addAttribute("student", student);
        return "UpdateStudent";
    }




    @PutMapping("/updateStudent")
    public String updateStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/showStudentList";
    }

    @GetMapping("/findStudentsName")
    public String showStudentList(Model model, @Param("keyword") String keyword){
        List<Student> students = studentService.findStudentByName(keyword);
        model.addAttribute("students", students);
        return "students";
    }

    @GetMapping("/studentFilterList")
    @ResponseBody
    public List<Student> showStudentFilterList(Model model,@RequestParam String keyword , @RequestParam String studentState) {
        List<Student> lst_Students = null;
        if(studentState.equals("all")) {
            lst_Students = studentService.findStudentsByNameContains(keyword);
        }
        else {
            lst_Students = studentService.findStudentsFilter(studentState, keyword);
        }
        model.addAttribute("lst_Student", lst_Students);
        return lst_Students;
    }
}
