package com.example.dormitorymanagement.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Contract implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int contractId;

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

    public Contract(Student student, String tenHopDong, Date signingDate, Date expirationDate) {
        this.student=student;
        this.ContractName=tenHopDong;
        this.SigningDate=signingDate;
        this.ExpirationDate=expirationDate;
    }
}
