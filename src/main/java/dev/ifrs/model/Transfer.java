package dev.ifrs.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.util.Date;
 
@Entity
@Table(name = "T_TRANSFER")
public class Transfer {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String accountFrom;
    private String accountTo;
    private Date transferDate;
    private BigDecimal amount;
 
    public Transfer() {
    }
 
    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public String getAccountFrom() {
        return accountFrom;
    }
 
    public void setAccountFrom(String accountFrom) {
        this.accountFrom = accountFrom;
    }
 
    public String getAccountTo() {
        return accountTo;
    }
 
    public void setAccountTo(String accountTo) {
        this.accountTo = accountTo;
    }
 
    public Date getTransferDate() {
        return transferDate;
    }
 
    public void setTransferDate(Date transferDate) {
        this.transferDate = transferDate;
    }
 
    public BigDecimal getAmount() {
        return amount;
    }
 
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
