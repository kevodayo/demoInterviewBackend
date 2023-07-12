package com.example.interviewdemoproject.Model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "DEMO_ACCOUNT")
public class Account {
    @Id
    @GeneratedValue
    private BigDecimal id;
    @ManyToOne
    @JoinColumn(name = "customer_code")
    @NotFound( action = NotFoundAction.IGNORE )
    private Customer customer;
    @Column(name = "balance")
    private BigDecimal balance;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    @Column(name = "transaction")
    private List<Transaction> transactions;
}
