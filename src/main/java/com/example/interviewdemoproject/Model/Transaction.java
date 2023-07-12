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
@Table(name = "DEMO_TRANSACTION")
public class Transaction {
    @Id
    @GeneratedValue
    private BigDecimal id;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
    @Column(name = "amount")
    private BigDecimal amount;
}
