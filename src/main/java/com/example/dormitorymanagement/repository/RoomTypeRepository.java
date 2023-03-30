package com.example.dormitorymanagement.repository;

import com.example.dormitorymanagement.entity.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomTypeRepository extends JpaRepository<RoomType, Integer> {



    RoomType findRoomTypeByRoomTypeId(Integer id);
}
