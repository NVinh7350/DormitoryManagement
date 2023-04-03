package com.example.dormitorymanagement.repository;

import com.example.dormitorymanagement.entity.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomTypeRepository extends JpaRepository<RoomType, Integer> {
    public List<RoomType> findAllByRoomTypeNameContaining(String name);
}
