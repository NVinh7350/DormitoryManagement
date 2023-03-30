package com.example.dormitorymanagement.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @Column(columnDefinition = "varchar(20)")
    private String employeeId;

    @Column(columnDefinition = "nvarchar(50)")
    private String employeeName;

    @Column(columnDefinition = "varchar(10)")
    private String phone;

    @Column(columnDefinition = "varchar(254)")
    private String email;

    @Temporal(TemporalType.DATE)
    private Date birthDay;

    @Column(columnDefinition = "varchar(6)")
    private String gender;

    @Column(columnDefinition = "nvarchar(100)")
    private String address;

    @OneToOne
    @JoinColumn(name = "userName", nullable = false, referencedColumnName = "userName")
    private Account account;
}
