package com.example.dormitorymanagement.service;

import com.example.dormitorymanagement.entity.Room;
import com.example.dormitorymanagement.entity.RoomType;
import com.example.dormitorymanagement.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomRepository roomRepository;
    @Override
    public List<Room> getAllRoom() {
        return roomRepository.findAll();
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

}
