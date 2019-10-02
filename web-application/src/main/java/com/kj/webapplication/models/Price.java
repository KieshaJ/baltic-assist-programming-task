package com.kj.webapplication.models;

import com.kj.webapplication.utils.enums.CurrencyEnum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Price extends Audit {
    @Id
    @GeneratedValue
    private UUID id;
    @Column(nullable = false)
    private Double amount;
    @Column(nullable = false)
    private CurrencyEnum currency;

    protected Price() {}

    public Price(UUID id, Double amount, CurrencyEnum currency) {
        this.id = id;
        this.amount = amount;
        this.currency = currency;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public CurrencyEnum getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyEnum currency) {
        this.currency = currency;
    }
}
