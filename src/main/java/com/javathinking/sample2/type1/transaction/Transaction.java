package com.javathinking.sample2.type1.transaction;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Private setters make this entity immutable
 */
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "fileRef")
    private String fileRef;

    @Column(name = "client")
    private String client;

    @Column(name = "account")
    private String account;
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @Column(name = "date")
    private DateTime date;
    @Column(name = "amount")
    private BigDecimal amount;

    // derived values - computed during processing
    @Column(name = "category")
    private String category;

    public Transaction() {
    }

    public Transaction(String fileRef, String client, String account, DateTime date, BigDecimal amount) {
        this.fileRef = fileRef;
        this.client = client;
        this.account = account;
        this.date = date;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public String getClient() {
        return client;
    }

    private void setClient(String client) {
        this.client = client;
    }

    public String getAccount() {
        return account;
    }

    private void setAccount(String account) {
        this.account = account;
    }

    public DateTime getDate() {
        return date;
    }

    private void setDate(DateTime date) {
        this.date = date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    private void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getFileRef() {
        return fileRef;
    }

    public void setFileRef(String fileRef) {
        this.fileRef = fileRef;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
