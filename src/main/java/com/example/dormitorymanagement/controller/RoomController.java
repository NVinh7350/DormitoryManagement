package com.example.dormitorymanagement.controller;

import com.example.dormitorymanagement.entity.Room;
import com.example.dormitorymanagement.entity.RoomType;
import com.example.dormitorymanagement.service.RoomService;
import com.example.dormitorymanagement.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RoomController {
    @Autowired
    private RoomTypeService roomTypeService;
    @Autowired
    private RoomService roomService;

    @GetMapping("/addRoom")
    public String addRoom(Model model) {
        Room room = new Room();
        List<RoomType> lstRoomType = roomTypeService.getAllRoomType();
        model.addAttribute("typeRoomList", lstRoomType);
        model.addAttribute("tieude", "Quản lí phòng");
        model.addAttribute("room" , room);
        return "AddRoom";
    }

    @PostMapping("/addRoom")
    public String addRoom(@ModelAttribute("room") Room room, Model model) {
        roomService.saveRoom(room);
        model.addAttribute("message", "Success");
        return "redirect:/addRoom";
    }

    @GetMapping("/listAllRoom")
    public String listAllRoom(Model model) {
        List<Room> lstroom = roomService.getAllRoom();
        model.addAttribute("listRoom", lstroom);
        model.addAttribute("tieude", "Quản lí phòng");
        return "RoomList";
    }
    @GetMapping("/deleteRoom/{id}")
    public String deleteRoom(@PathVariable(value="id") int id, Model model) {
        roomService.deleteRoom(id);
        model.addAttribute("message", "Success");
        return "redirect:/listAllRoom";
    }

    @GetMapping("/updateRoom/{id}")
    public String updateRoom(@PathVariable(value="id") int id, Model model) {
        Room room = roomService.getRoomById(id);
        model.addAttribute("room", room);
        List<RoomType> lstRoomType = roomTypeService.getAllRoomType();
        model.addAttribute("typeRoomList", lstRoomType);
        model.addAttribute("tieude", "Quản lí phòng");
        return "UpdateRoom";

    }

    @PutMapping("/updateRoom")
    public String updateRoom(@ModelAttribute("room") Room room) {
        roomService.saveRoom(room);
        return "redirect:/listAllRoom";
    }


}
