package com.example.dormitorymanagement.service;

import com.example.dormitorymanagement.entity.RoomType;

import java.util.List;

public interface RoomTypeService {
    public void saveRoomType(RoomType roomType);
    public List<RoomType> getAllRoomType();
    public void deleteRoomTypebyId(int id);
    public RoomType getRoomTypebyId(int id);

}
