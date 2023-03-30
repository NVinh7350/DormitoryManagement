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

    @ManyToOne
    @JoinColumn(name = "roomTypeId", nullable = false, referencedColumnName = "roomTypeId")
    @JsonBackReference
    private RoomType roomType;
}
