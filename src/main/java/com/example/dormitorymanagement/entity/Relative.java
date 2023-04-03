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
@IdClass(Student.class)
public class Relative {
    @Id
    @OneToOne
    @JoinColumn(name = "studentId", nullable = false, referencedColumnName = "studentId")
    private Student student;

    @Column(columnDefinition = "nvarchar(50)")
    private String relativeName;

    @Column(columnDefinition = "varchar(10)")
    private String phone;

    @Column(columnDefinition = "varchar(254)")
    private String email;

    @Temporal(TemporalType.DATE)
    private Date birthDay;

    @Column(columnDefinition = "nvarchar(100)")
    private String address;

}
