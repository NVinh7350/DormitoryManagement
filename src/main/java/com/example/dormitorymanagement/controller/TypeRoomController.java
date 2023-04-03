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
public class TypeRoomController {

    @Autowired
    private RoomTypeService roomTypeService;
    @Autowired
    private RoomService roomService;
    @GetMapping("/addRoomType")
    public String addRoomType(Model model) {
        RoomType roomType = new RoomType();
        model.addAttribute("roomtype" , roomType);
        model.addAttribute("tieude", "Quản lí loại phòng");
        return "AddRoomType";
    }

    @PostMapping("/addRoomType")
    public String saveRoomType(@ModelAttribute("roomtype") RoomType roomType, Model model) {
        roomTypeService.saveRoomType(roomType);
        model.addAttribute("message", "Success");
        return "redirect:/addRoomType";
    }

    @GetMapping("/listRoomType")
    public String getAllRoomType(Model model) {
        List<RoomType> lstRoomType = roomTypeService.getAllRoomType();
        model.addAttribute("typeRoomList", lstRoomType);
        model.addAttribute("tieude", "Quản lí loại phòng");
        return "TypeRoomList";
    }
    @GetMapping("/deleteRoomType/{id}")
    public String deleteRoomType(@PathVariable(value="id") int id) {
        roomTypeService.deleteRoomTypebyId(id);
        return "redirect:/listRoomType";
    }

    @GetMapping("/updateRoomType/{id}")
    public String updateRoomType(@PathVariable(value = "id") int id, Model model) {
        RoomType roomType = roomTypeService.getRoomTypebyId(id);
        model.addAttribute("RoomTypeObj", roomType);
        model.addAttribute("tieude", "Quản lí loại phòng");
        return "UpdateRoomType";
    }
    @PutMapping("/updateRoomType")
    public String updateRoomType(@ModelAttribute("RoomTypeObj") RoomType roomType) {
        roomTypeService.saveRoomType(roomType);
        return "redirect:/listRoomType";
    }

    @GetMapping("/getRoombyTypeId/{id}")
    public String getRoombyTypeId(@PathVariable(value = "id") int id, Model model) {
        List<Room> lstRoom = roomService.getRoomByTypeId(id);
        model.addAttribute("listRoom", lstRoom);
        model.addAttribute("tieude", "Quản lí phòng");
        return "RoomList";
    }
}
