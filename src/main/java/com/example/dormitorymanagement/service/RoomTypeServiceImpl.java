package com.example.dormitorymanagement.service;

import com.example.dormitorymanagement.entity.RoomType;
import com.example.dormitorymanagement.repository.RoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomTypeServiceImpl implements RoomTypeService {
    @Autowired
    private RoomTypeRepository roomTypeRepository;
    @Override
    public void saveRoomType(RoomType roomType) {
        roomTypeRepository.save(roomType);
    }
    @Override
    public List<RoomType> getAllRoomType() {
        return roomTypeRepository.findAll();
    }
    @Override
    public void deleteRoomTypebyId(int id) {
        roomTypeRepository.deleteById(id);
    }

    @Override
    public RoomType getRoomTypebyId(int id) {
        Optional<RoomType> optional = roomTypeRepository.findById(id);
        RoomType roomType = null;
        if(optional.isPresent()) {
            roomType = optional.get();
        }
        else {
            throw  new RuntimeException("RoomType not found for id ::"+id);
        }
        return roomType;
    }




}
