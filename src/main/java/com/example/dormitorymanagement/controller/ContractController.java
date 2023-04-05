package com.example.dormitorymanagement.controller;

import com.example.dormitorymanagement.dto.ContractDTO;
import com.example.dormitorymanagement.entity.*;
import com.example.dormitorymanagement.service.ContractService;
import com.example.dormitorymanagement.service.RoomService;
import com.example.dormitorymanagement.service.RoomTypeService;
import com.example.dormitorymanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Date;
import java.util.List;

@Controller
public class ContractController {
    @Autowired
    private ContractService contractService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private RoomTypeService roomTypeService;


    //Tao hop dong
    @GetMapping("/showStudentApprovalForm/{id}/{idRoom}")
    public String showStudentApprovalForm(@PathVariable(value="id") String id,@PathVariable(value="idRoom") Integer idRoom, Model model){
        Room room = roomService.getRoomById(idRoom);
        RoomType roomType=roomTypeService.getRoomTypebyId(room.getRoomType().getRoomTypeId());
        Student student = studentService.getElementById(id);
        ContractDTO contractDTO=new ContractDTO(room,roomType,student);
        Contract contract=new Contract();
        model.addAttribute("contractDTO", contractDTO);
        model.addAttribute("contract", contract);
        return "StudentApproval";
    }
    @PostMapping("/createContract")
    public String createContract(@RequestParam("id") String idStudent
            , @RequestParam("tenHopDong") String tenHopDong
            ,@RequestParam("SigningDate") String SigningDate
            ,@RequestParam("ExpirationDate") String ExpirationDate
            , Model model){
        Student student = studentService.getElementById(idStudent);
        student.setStudentState("live");
        studentService.saveStudent(student);
        Contract contract=new Contract(student,tenHopDong,java.sql.Date.valueOf(SigningDate),java.sql.Date.valueOf(ExpirationDate));
        contractService.saveContract(contract);
        return  "redirect:/showStudentList";
    }
    @GetMapping("/showListConTract")
    public String showListConTract(Model model){
        List<Contract> contracts = contractService.getAll();
        model.addAttribute("contracts", contracts);
        return "ContractHistory";
    }
    @GetMapping("/showContractDetail/{id}")
    public String showListConTract(@PathVariable(value="id") Integer id,Model model){
      Contract contract = contractService.getContractId(id);
        model.addAttribute("contract", contract);
        return "ContractDetail";
    }

}
