package com.example.dormitorymanagement.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Serializable {
    @Id
    @Column(columnDefinition = "varchar(12)")
    private String studentId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "roomId", nullable = true, referencedColumnName = "roomId")
    @JsonBackReference
    private Room room;

    @Column(columnDefinition = "nvarchar(50)")
    private String studentName;

    @Column(columnDefinition = "varchar(10)")
    private String phone;

    @Column(columnDefinition = "varchar(254)")
    private String email;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDay;

    @Column(columnDefinition = "varchar(6)")
    private String gender;

    @Column(columnDefinition = "nvarchar(100)")
    private String address;

    @Column(columnDefinition = "varchar(10)")
    private String studentState;

    @Column(columnDefinition = "nvarchar(50)")
    private String relativeName;

    @Column(columnDefinition = "varchar(10)")
    private String relativePhone;

    @Column(columnDefinition = "nvarchar(100)")
    private String relativeAddress;

    @OneToOne
    @JoinColumn(name = "studentId", nullable = false, referencedColumnName = "userName")
    private Account account;
}
