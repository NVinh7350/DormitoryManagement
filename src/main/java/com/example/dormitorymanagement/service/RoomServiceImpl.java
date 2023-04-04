package com.example.dormitorymanagement.service;

import com.example.dormitorymanagement.entity.Room;
import com.example.dormitorymanagement.entity.RoomType;
import com.example.dormitorymanagement.repository.RoomRepository;
import com.example.dormitorymanagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public List<Room> getAllRoom() {
        List<Room> listAllRoom = roomRepository.findAll();
        for(Room room : listAllRoom){
            room.setStudentNumberInRoom(studentRepository.findAllByRoom_RoomId(room.getRoomId()).size());
        }
        return listAllRoom;
    }
    @Override
    public void saveRoom(Room room) {
        roomRepository.save(room);
    }

    @Override
    public List<Room> getRoomByTypeId(int id) {
        return roomRepository.findRoomsByRoomTypeRoomTypeId(id);
    }

    @Override
    public void deleteRoom(int id) {
        roomRepository.deleteById(id);
    }
    @Override
    public Room getRoomById(int id) {
        Optional<Room> optional = roomRepository.findById(id);
        Room room = null;
        if(optional.isPresent()) {
            room = optional.get();
        }
        else {
            throw  new RuntimeException("Room not found for id ::"+id);
        }
        return room;
    }

    @Override
    public List<Room> getRoomListByName(String name) {
        return roomRepository.findAllByRoomNameContaining(name);
    }
}
