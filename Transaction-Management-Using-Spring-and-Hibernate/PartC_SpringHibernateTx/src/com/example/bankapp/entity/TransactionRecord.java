package com.example.bankapp.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transaction_record")
public class TransactionRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String fromAccount;

    @Column
    private String toAccount;

    @Column
    private double amount;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public TransactionRecord() {}

    public TransactionRecord(String fromAccount, String toAccount, double amount) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
        this.date = new Date();
    }

    @Override
    public String toString() {
        return "TransactionRecord [from=" + fromAccount + ", to=" + toAccount + ", amount=" + amount + ", date=" + date + "]";
    }
}
