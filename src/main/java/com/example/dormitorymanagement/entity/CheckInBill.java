package com.example.dormitorymanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheckInBill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int checkInBillId;

    @Column(columnDefinition = "varchar(20)")
    private String studentId;

    @Column(columnDefinition = "varchar(20)")
    private String employeeId;

    @Temporal(TemporalType.DATE)
    private Date billDate;

    @Column(columnDefinition = "ntext")
    private  String moreInformation;




}
