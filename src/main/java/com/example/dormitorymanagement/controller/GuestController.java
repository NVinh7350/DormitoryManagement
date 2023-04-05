package com.example.dormitorymanagement.controller;

import com.example.dormitorymanagement.entity.*;
import com.example.dormitorymanagement.service.EmployeeService;
import com.example.dormitorymanagement.service.RoomService;
import com.example.dormitorymanagement.service.RoomTypeService;
import com.example.dormitorymanagement.service.SurchargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/guest")
public class GuestController {
    @Autowired
    private RoomTypeService roomTypeService;
    @Autowired
    private RoomService roomService;
    @Autowired
    private SurchargeService surchargeService;
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/home")
    public String showHome(Model model){
        return "GuestHome";
    }

    @GetMapping("/rooms")
    public String showRooms(Model model){
        List<RoomType> roomTypeList = roomTypeService.getAllRoomType();
        List<Room> roomList = roomService.getAllRoom();
        model.addAttribute("roomTypeList", roomTypeList);
        model.addAttribute("roomList", roomList);
        model.addAttribute("title", "THÔNG TIN PHÒNG");
        return "GuestRooms";
    }

    @GetMapping("/rooms/{id}")
    public String showDetail(@PathVariable(value="id") int id, Model model) {
        RoomType roomTypeCurrent = roomTypeService.getRoomTypebyId(id);
        model.addAttribute("roomTypeCurent", roomTypeCurrent);
        List<RoomType> roomTypeList = roomTypeService.getAllRoomType();
        roomTypeList.remove(roomTypeCurrent);
        model.addAttribute("roomTypeList", roomTypeList);
        model.addAttribute("title", "THÔNG TIN CHI TIẾT LOẠI PHÒNG");
        return "GuestDetailRoom";
    }

    @GetMapping("/procedure")
    public String showProcedure(Model model) {
        model.addAttribute("title", "THÔNG TIN THỦ TỤC");
        return "GuestProcedure";
    }

    @GetMapping("/surcharge")
    public String showSurcharge(Model model) {
        List<Surcharge> surchargeList = surchargeService.getAllSurcharge();
        model.addAttribute("surchargeList", surchargeList);
        model.addAttribute("title", "THÔNG TIN BẢNG GIÁ");
        return "GuestSurcharge";
    }

    @GetMapping("/contact")
    public String showContact(Model model) {
        List<Employee> employeeList = employeeService.getAllEmployee();
        model.addAttribute("employeeList", employeeList);
        model.addAttribute("title", "THÔNG TIN LIÊN LẠC");
        return "GuestContact";
    }

    @GetMapping("/registerRoom/{id}")
    public String registerRoom(@PathVariable(value="id") int id, Model model) {
        Room room = roomService.getRoomById(id);
        model.addAttribute("room", room);
        Student student=new Student();
        student.setRoom(room);
        model.addAttribute("student", student);
        model.addAttribute("title", "ĐẶT PHÒNG");
        return "RegisterRoom";
    }

    @GetMapping("/login")
    public String showLogin(Model model) {
        Account account = new Account();
        model.addAttribute("account", account);
        return "GuestContact";
    }

}
