package com.example.dormitorymanagement.dto;

import com.example.dormitorymanagement.entity.Room;
import com.example.dormitorymanagement.entity.RoomType;
import com.example.dormitorymanagement.entity.Student;

import java.math.BigDecimal;

public class ContractDTO {
    private Room room;
    private RoomType roomType;
    private Student student;

    public ContractDTO(Room room, RoomType roomType, Student student) {
        this.room = room;
        this.roomType = roomType;
        this.student = student;
    }
    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}

