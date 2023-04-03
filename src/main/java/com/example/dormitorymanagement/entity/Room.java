package com.example.dormitorymanagement.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roomId;

    @Column(columnDefinition = "nvarchar(10)")
    private String roomName;
    private int Electricity;
    private int Water;

    @ManyToOne()
    @JoinColumn(name = "roomTypeId", nullable = true, referencedColumnName = "roomTypeId")
    private RoomType roomType;
    @Transient
    private int studentNumberInRoom;
}
