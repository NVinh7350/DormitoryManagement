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
public class Account {
    @Id
    @Column(columnDefinition = "varchar(12)")
    private String userName;

    @Column(columnDefinition = "varchar(12)")
    private String password;

    @Column(columnDefinition = "nvarchar(8)")
    private String accountType;
}
