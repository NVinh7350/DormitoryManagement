package com.example.dormitorymanagement.controller;

import com.example.dormitorymanagement.entity.RoomType;
import com.example.dormitorymanagement.repository.RoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {


    @Autowired
    RoomTypeRepository repository;
    @RequestMapping("hello")
    @ResponseBody
    public RoomType test(){
        RoomType room = new RoomType();
        room.setRoomTypeId(repository.findAll().size() + 1);
        room.setRoomTypeName("hehehhehe");
        repository.save(room);
        return repository.findRoomTypeByRoomTypeId(2);
    }
}
