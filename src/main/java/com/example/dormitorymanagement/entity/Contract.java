package com.example.dormitorymanagement.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contract
{
    @Id
    @ManyToOne
    @JoinColumn(name = "studentId", nullable = false, referencedColumnName = "studentId")
    private Student student;

    @Column(columnDefinition = "nvarchar(50)")
    private String ContractName;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date SigningDate;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ExpirationDate ;

}
