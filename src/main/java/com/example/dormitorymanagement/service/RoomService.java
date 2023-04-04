package com.example.dormitorymanagement.service;

import com.example.dormitorymanagement.entity.Room;

import java.util.List;

public interface RoomService {
    public List<Room> getAllRoom();
    public void saveRoom(Room room);
    public List<Room> getRoomByTypeId(int id);
    public void deleteRoom(int id);
    public Room getRoomById(int id);
    public List<Room> getRoomListByName(String name);

}
