package com.kj.webapplication.utils.details;

import com.kj.webapplication.utils.enums.CurrencyEnum;

public class PriceDetails {
    private Double amount;
    private CurrencyEnum currency;

    protected PriceDetails() {}

    public PriceDetails(Double amount, CurrencyEnum currency) {
        this.amount = amount;
        this.currency = currency;
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
