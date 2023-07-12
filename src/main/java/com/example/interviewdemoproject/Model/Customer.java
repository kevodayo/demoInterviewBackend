package com.example.interviewdemoproject.Model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "DEMO_CUSTOMER")
public class Customer {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private BigDecimal id;
    @Column(name = "customerName")
    private String customerName;
}
