package com.example.dormitorymanagement.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetailCheckInBill {
    @Id
    @ManyToOne
    @JoinColumn(name = "checkInBillId", nullable = false, referencedColumnName = "checkInBillId")
    private CheckInBill checkInBill;

    @Column(columnDefinition = "nvarchar(50)")
    private String surchargeName;

    @Column(columnDefinition = "money")
    private BigDecimal price;
}
