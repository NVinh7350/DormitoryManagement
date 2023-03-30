package com.example.dormitorymanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Surcharge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int surchargeId;

    @Column(columnDefinition = "nvarchar(50)")
    private String surchargeName;

    @Column(columnDefinition = "money")
    private BigDecimal price;

    @Column(columnDefinition = "ntext")
    private String moreInformation;

}
