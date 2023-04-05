package com.example.dormitorymanagement.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roomTypeId;
    @Column(name = "RoomTypeName", columnDefinition = "nvarchar(50)")
    private String roomTypeName;
    private int RoomCapacity;
    @Column(columnDefinition = "nvarchar(6)")
    private String GenderUser;
    @Column(columnDefinition = "nvarchar(255")
    private String TypeRoomDescription;
    @Column(columnDefinition = "money")
    private BigDecimal priceRoom;

    @OneToMany(mappedBy = "roomType", cascade = CascadeType.ALL)
    private Set<Room> rooms;

}
